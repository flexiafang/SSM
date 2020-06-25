package domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/8 19:23
 */
public class QueryVo implements Serializable {
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
