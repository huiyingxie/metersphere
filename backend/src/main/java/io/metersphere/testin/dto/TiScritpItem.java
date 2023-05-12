package io.metersphere.testin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/10 15:58
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TiScritpItem {

    @JsonProperty("scriptUpdateTime")
    private Long scriptUpdateTime;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("scriptUpdateUserid")
    private Integer scriptUpdateUserid;
    @JsonProperty("scriptid")
    private Integer scriptid;
    @JsonProperty("scriptNo")
    private Integer scriptNo;
    @JsonProperty("fileinfo")
    private FileinfoDTO fileinfo;
    @JsonProperty("scriptmain")
    private String scriptmain;
    @JsonProperty("adapterversioncode")
    private String adapterversioncode;
    @JsonProperty("channelId")
    private String channelId;
    @JsonProperty("suiteName")
    private String suiteName;
    @JsonProperty("suiteId")
    private Integer suiteId;
    @JsonProperty("scriptUpdateType")
    private Integer scriptUpdateType;
    @JsonProperty("recordType")
    private Integer recordType;
    @JsonProperty("taginfos")
    private String taginfos;
    @JsonProperty("ostype")
    private Integer ostype;
    @JsonProperty("scriptFromType")
    private Integer scriptFromType;
    @JsonProperty("declareVars")
    private String declareVars;
    @JsonProperty("build")
    private Integer build;
    @JsonProperty("imageurl")
    private String imageurl;
    @JsonProperty("scriptCreateUser")
    private Integer scriptCreateUser;
    @JsonProperty("scriptName")
    private String scriptName;
    @JsonProperty("scriptCreateDesc")
    private String scriptCreateDesc;
    @JsonProperty("pkgid")
    private Integer pkgid;
    @JsonProperty("adapterversionname")
    private String adapterversionname;
    @JsonProperty("projectId")
    private Integer projectId;
    @JsonProperty("scriptCreateTime")
    private Long scriptCreateTime;

    public Long getScriptUpdateTime() {
        return scriptUpdateTime;
    }

    public void setScriptUpdateTime(Long scriptUpdateTime) {
        this.scriptUpdateTime = scriptUpdateTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getScriptUpdateUserid() {
        return scriptUpdateUserid;
    }

    public void setScriptUpdateUserid(Integer scriptUpdateUserid) {
        this.scriptUpdateUserid = scriptUpdateUserid;
    }

    public Integer getScriptid() {
        return scriptid;
    }

    public void setScriptid(Integer scriptid) {
        this.scriptid = scriptid;
    }

    public Integer getScriptNo() {
        return scriptNo;
    }

    public void setScriptNo(Integer scriptNo) {
        this.scriptNo = scriptNo;
    }

    public FileinfoDTO getFileinfo() {
        return fileinfo;
    }

    public void setFileinfo(FileinfoDTO fileinfo) {
        this.fileinfo = fileinfo;
    }

    public String getScriptmain() {
        return scriptmain;
    }

    public void setScriptmain(String scriptmain) {
        this.scriptmain = scriptmain;
    }

    public String getAdapterversioncode() {
        return adapterversioncode;
    }

    public void setAdapterversioncode(String adapterversioncode) {
        this.adapterversioncode = adapterversioncode;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public Integer getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(Integer suiteId) {
        this.suiteId = suiteId;
    }

    public Integer getScriptUpdateType() {
        return scriptUpdateType;
    }

    public void setScriptUpdateType(Integer scriptUpdateType) {
        this.scriptUpdateType = scriptUpdateType;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public String getTaginfos() {
        return taginfos;
    }

    public void setTaginfos(String taginfos) {
        this.taginfos = taginfos;
    }

    public Integer getOstype() {
        return ostype;
    }

    public void setOstype(Integer ostype) {
        this.ostype = ostype;
    }

    public Integer getScriptFromType() {
        return scriptFromType;
    }

    public void setScriptFromType(Integer scriptFromType) {
        this.scriptFromType = scriptFromType;
    }

    public String getDeclareVars() {
        return declareVars;
    }

    public void setDeclareVars(String declareVars) {
        this.declareVars = declareVars;
    }

    public Integer getBuild() {
        return build;
    }

    public void setBuild(Integer build) {
        this.build = build;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Integer getScriptCreateUser() {
        return scriptCreateUser;
    }

    public void setScriptCreateUser(Integer scriptCreateUser) {
        this.scriptCreateUser = scriptCreateUser;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getScriptCreateDesc() {
        return scriptCreateDesc;
    }

    public void setScriptCreateDesc(String scriptCreateDesc) {
        this.scriptCreateDesc = scriptCreateDesc;
    }

    public Integer getPkgid() {
        return pkgid;
    }

    public void setPkgid(Integer pkgid) {
        this.pkgid = pkgid;
    }

    public String getAdapterversionname() {
        return adapterversionname;
    }

    public void setAdapterversionname(String adapterversionname) {
        this.adapterversionname = adapterversionname;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Long getScriptCreateTime() {
        return scriptCreateTime;
    }

    public void setScriptCreateTime(Long scriptCreateTime) {
        this.scriptCreateTime = scriptCreateTime;
    }

    public static class FileinfoDTO {
        @JsonProperty("createUserId")
        private Integer createUserId;
        @JsonProperty("expireTime")
        private Integer expireTime;
        @JsonProperty("size")
        private Integer size;
        @JsonProperty("createTime")
        private Long createTime;
        @JsonProperty("uploadUserName")
        private String uploadUserName;
        @JsonProperty("fileUrl")
        private String fileUrl;
        @JsonProperty("isdelete")
        private Integer isdelete;
        @JsonProperty("filemd5")
        private String filemd5;
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("fileId")
        private Integer fileId;

        public Integer getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(Integer createUserId) {
            this.createUserId = createUserId;
        }

        public Integer getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(Integer expireTime) {
            this.expireTime = expireTime;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public String getUploadUserName() {
            return uploadUserName;
        }

        public void setUploadUserName(String uploadUserName) {
            this.uploadUserName = uploadUserName;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public Integer getIsdelete() {
            return isdelete;
        }

        public void setIsdelete(Integer isdelete) {
            this.isdelete = isdelete;
        }

        public String getFilemd5() {
            return filemd5;
        }

        public void setFilemd5(String filemd5) {
            this.filemd5 = filemd5;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getFileId() {
            return fileId;
        }

        public void setFileId(Integer fileId) {
            this.fileId = fileId;
        }
    }

    @Override
    public String toString() {
        return "TiScritpItem{" +
                "scriptUpdateTime=" + scriptUpdateTime +
                ", type=" + type +
                ", scriptUpdateUserid=" + scriptUpdateUserid +
                ", scriptid=" + scriptid +
                ", scriptNo=" + scriptNo +
                ", fileinfo=" + fileinfo +
                ", scriptmain='" + scriptmain + '\'' +
                ", adapterversioncode='" + adapterversioncode + '\'' +
                ", channelId='" + channelId + '\'' +
                ", suiteName='" + suiteName + '\'' +
                ", suiteId=" + suiteId +
                ", scriptUpdateType=" + scriptUpdateType +
                ", recordType=" + recordType +
                ", taginfos='" + taginfos + '\'' +
                ", ostype=" + ostype +
                ", scriptFromType=" + scriptFromType +
                ", declareVars='" + declareVars + '\'' +
                ", build=" + build +
                ", imageurl='" + imageurl + '\'' +
                ", scriptCreateUser=" + scriptCreateUser +
                ", scriptName='" + scriptName + '\'' +
                ", scriptCreateDesc='" + scriptCreateDesc + '\'' +
                ", pkgid=" + pkgid +
                ", adapterversionname='" + adapterversionname + '\'' +
                ", projectId=" + projectId +
                ", scriptCreateTime=" + scriptCreateTime +
                '}';
    }
}
