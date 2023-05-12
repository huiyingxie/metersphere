package io.metersphere.testin.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 9:14
 */
@Getter
@Setter
public class OnlineUserData {
    protected OnlineUserInfoDTO onlineUserInfo;

    public OnlineUserData buildUser(String email) {
        onlineUserInfo = new OnlineUserInfoDTO(email);
        return this;
    }
}
