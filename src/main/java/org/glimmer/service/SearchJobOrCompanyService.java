package org.glimmer.service;

import org.glimmer.domain.ResponseResult;

public interface SearchJobOrCompanyService {
    public ResponseResult searchJobOrCompany(String keyword);
}
