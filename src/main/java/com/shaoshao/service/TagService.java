package com.shaoshao.service;

import com.shaoshao.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2020/9/30 9:32
 */
public interface TagService {

    Tag saveTag(Tag tag);
    Tag getTag(Long id);
    Tag getTagByName(String name);
    Page<Tag> listTag(Pageable pageable);
    List<Tag> listTag();
    List<Tag> listTagTop(Integer size);
    List<Tag> listTag(String ids);
    Tag updateTag(Long id,Tag tag);
    void deleteTag(Long id);


}
