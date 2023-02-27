package model.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xnd
 * @since 2023/2/18 15:07
 */
@Data
@ApiModel
public class SysUserVO {
    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty("昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("身份证号")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("联系方式")
    @TableField("tel")
    private String tel;
}
