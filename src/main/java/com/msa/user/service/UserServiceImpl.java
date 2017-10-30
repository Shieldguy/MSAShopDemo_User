package com.msa.user.service;

import com.msa.common.service.CrudPagingEntityServiceImpl;
import com.msa.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends CrudPagingEntityServiceImpl<User, Long> {
}
