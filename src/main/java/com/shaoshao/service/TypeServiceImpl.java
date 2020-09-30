package com.shaoshao.service;

import com.shaoshao.NotFoundException;
import com.shaoshao.dao.TypeRespository;
import com.shaoshao.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/29 15:10
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRespository typeRespository;
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRespository.save(type);
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRespository.findById(id).get();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRespository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRespository.findAll(pageable);
    }
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRespository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRespository.save(t);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRespository.deleteById(id);
    }
}
