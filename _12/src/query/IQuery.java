package query;

import java.util.List;

public interface IQuery {
    String getQuery();
    List<Object> getParameters();
}
