package com.wt.friendship.common;

import lombok.Data;

@Data
public class PageRequest {
    /**
     * 页面大小
     */
    protected int pageSize=10;

    /**
     * 当前第几页
     */
    protected int pageNum=1;
}
