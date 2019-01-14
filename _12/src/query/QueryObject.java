package query;

import java.util.*;

public class QueryObject implements IQuery {

    private List<String> conditions = new ArrayList<>();
    private List<Object> parameters = new ArrayList<>();
    Map<String, String> orderByMap = new LinkedHashMap<>();

    @Override
    public String getQuery() {
        StringBuilder sql = new StringBuilder(200);
        this.customized();
        for (int i = 0; i < conditions.size(); i++) {
            if (i == 0) {
                sql.append(" WHERE ");
            } else {
                sql.append(" AND ");
            }
            sql.append(conditions.get(i));
        }

        if (orderByMap.size() > 0) {
            sql.append(" ORDER BY ");
            Set<Map.Entry<String, String>> entrySet = orderByMap.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                String columnName = entry.getKey();
                String orderByType = entry.getValue();
                sql.append(columnName)
                        .append(" ")
                        .append(orderByType)
                        .append(",");
            }
            sql.deleteCharAt(sql.length() - 1);
        }
        return sql.toString();
    }

    @Override
    public List<Object> getParameters() {
        return this.parameters;
    }

    protected void customized() {
    }

    protected void addQuery(String condition, Object... objects) {
        this.conditions.add("(" + condition + ")");
        this.parameters.addAll(Arrays.asList(objects));
    }

    protected void setOrderBy(String columnName, OrderBy orderByType) {
        orderByMap.put(columnName, orderByType.name());
    }

    enum OrderBy {
        ASC, DESC;
    }

}
