package bilibili.a_crud.entity;

import java.util.List;

/**
 * Author:BY
 * Date:2020/3/24
 * Description:
 */
public class QueryVo {

    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

