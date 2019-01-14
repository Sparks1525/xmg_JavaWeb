package page;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

// 分页的结果集对象:封装了所有的分页信息
@Data
public class PageResult {

    private List listData; //当前页的结果集:通过SQL查询出来的
    private Integer totalCount; //结果总数,通过SQL查询出来的
    private Integer currentPage = 1; //当前页
    private Integer pageSize = 10; //每页最多显示多少条数据
    private Integer beginPage = 1; //首页
    private Integer prevPage; //上页
    private Integer nextPage; //下页
    private Integer totalPage; //末页/总页数

    private Integer beginIndex;
    private Integer endIndex;
    // 供用户选择每页显示多少条数据
    private List<Integer> pageSizeItems = Arrays.asList(3,5,10);


    public PageResult(List listData,
                      Integer totalCount,
                      Integer currentPage,
                      Integer pageSize) {
        this.listData = listData;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        // -----------------------------------------
        this.totalPage = this.totalCount % this.pageSize == 0 ?
                this.totalCount / this.pageSize :
                this.totalCount / this.pageSize + 1;
        this.prevPage = this.currentPage - 1 >= 1 ? this.currentPage - 1 : 1;
        this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1 : this.totalPage;
        // 获取页码的开始和结束索引
        PageIndex pageIndex = PageIndex.getPageIndex(5,currentPage,totalPage);
        this.beginIndex = pageIndex.getBeginIndex();
        this.endIndex = pageIndex.getEndIndex();

    }

}
