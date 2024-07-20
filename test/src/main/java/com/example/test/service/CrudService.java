package com.example.test.service;

import java.util.List;

public interface CrudService<RequestDto, ResponseDto> {

    ResponseDto create(RequestDto requestDto);

    ResponseDto update(Long id, RequestDto requestDto);

    void delete(Long id);

    ResponseDto findById(Long id);

    List<ResponseDto> findAll();
}