package com.user.service.service;


import com.user.service.dto.UserInfo;
import com.user.service.entities.Invoice;
import com.user.service.entities.UserE;
import com.user.service.repos.InvoiceRepository;
import com.user.service.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final InvoiceRepository invoiceRepository;

    public List<UserInfo> createUsers(List<UserInfo> userInfoList) {

        List<UserE> userEList =
        userInfoList.stream()
                .map(this::populateUser)
                .collect(Collectors.toList());

        List<UserE> createdUserES = userRepository.saveAll(userEList);

        return
        createdUserES.stream()
                .map(this::populateUserInfo)
                .collect(Collectors.toList());

    }

    public List<UserInfo> getUsers(List<String> ids) {

        log.info("Looking for records with ids : {} ", ids);

        List<UserE> userES = userRepository.findAllById(ids);

        userES.stream()
                .forEach(userE -> {
                    List<Invoice> invoices = invoiceRepository.findAllByUserId(userE.getId());
                    userE.setInvoiceNumbers(invoices);
                });

        return userES.stream()
                .map(this::populateUserInfo)
                .collect(Collectors.toList());
    }

    private UserE populateUser(UserInfo userInfo) {

        UserE userE = new UserE();
        userE.setName(userInfo.getName());
        userE.setAge(userInfo.getAge());
        userE.setGender(userE.getGender());


        return userE;
    }

    private UserInfo populateUserInfo(UserE userE) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userE.getId());
        userInfo.setName(userE.getName());
        userInfo.setAge(userE.getAge());
        userInfo.setGender(userE.getGender());
        userInfo.setCreatedTime(userE.getCreatedTime());
        userE.setUpdatedTime(userE.getUpdatedTime());

        if(userE.getInvoiceNumbers().size() > 0) {
            List<String> numbers = userE.getInvoiceNumbers().stream().map(Invoice::getInvoiceNumber).collect(Collectors.toList());
            userInfo.setInvoiceNumbers(numbers);

        } else {
            userInfo.setInvoiceNumbers(Collections.EMPTY_LIST);
        }

        return userInfo;
    }
}
