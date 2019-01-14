package query;

import java.util.List;

public interface IQuery {
    String getQuery(boolean setOrderBy);
    List<Object> getParameters();

    Integer getCurrentPage();
    Integer getPageSize();
}
