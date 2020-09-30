package com.shaoshao.service;

import com.shaoshao.NotFoundException;
import com.shaoshao.dao.TagRespository;
import com.shaoshao.dao.TypeRespository;
import com.shaoshao.po.Tag;
import com.shaoshao.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/30 9:38
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRespository tagRespository;
    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRespository.save(tag);
    }

    @Override
    @Transactional
    public Tag getTag(Long id) {
        return tagRespository.findById(id).get();
    }

    @Override
    @Transactional
    public Tag getTagByName(String name) {
        return tagRespository.findByName(name);
    }

    @Override
    @Transactional
    public Page<Tag> listTag(Pageable pageable) {
        return tagRespository.findAll(pageable);
    }

    @Override
    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRespository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该类型的标签");
        }
        BeanUtils.copyProperties(tag,t);
        return tagRespository.save(t);
    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
        tagRespository.deleteById(id);
    }
}
