package org.yqj.iron.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019-08-07
 * Email: yaoqijunmail@foxmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {

    private String hostname;

    private String hostAddress;

}
