package io.metersphere.testin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Describe
 *
 * @author maguangming
 * @since 2023/5/12 15:00
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskReportData {

    @JsonProperty("totalRow")
    private Integer totalRow;
    @JsonProperty("deviceAliasNameAggs")
    private List<String> deviceAliasNameAggs;
    @JsonProperty("totalPage")
    private Integer totalPage;
    @JsonProperty("resultCategoryAggs")
    private ResultCategoryAggsDTO resultCategoryAggs;
    @JsonProperty("pageSize")
    private Integer pageSize;
    @JsonProperty("deviceReolutionAggs")
    private List<?> deviceReolutionAggs;
    @JsonProperty("list")
    private List<ListDTO> list;
    @JsonProperty("scriptNoAggs")
    private List<Integer> scriptNoAggs;
    @JsonProperty("scriptDescrAggs")
    private List<String> scriptDescrAggs;
    @JsonProperty("deviceScreenSizeAggs")
    private List<Integer> deviceScreenSizeAggs;
    @JsonProperty("deviceReleaseVerAggs")
    private List<String> deviceReleaseVerAggs;
    @JsonProperty("deviceList")
    private List<DeviceListDTO> deviceList;
    @JsonProperty("scriptTagsAggs")
    private List<?> scriptTagsAggs;
    @JsonProperty("deviceRamAggs")
    private List<?> deviceRamAggs;
    @JsonProperty("page")
    private Integer page;

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public List<String> getDeviceAliasNameAggs() {
        return deviceAliasNameAggs;
    }

    public void setDeviceAliasNameAggs(List<String> deviceAliasNameAggs) {
        this.deviceAliasNameAggs = deviceAliasNameAggs;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public ResultCategoryAggsDTO getResultCategoryAggs() {
        return resultCategoryAggs;
    }

    public void setResultCategoryAggs(ResultCategoryAggsDTO resultCategoryAggs) {
        this.resultCategoryAggs = resultCategoryAggs;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getDeviceReolutionAggs() {
        return deviceReolutionAggs;
    }

    public void setDeviceReolutionAggs(List<?> deviceReolutionAggs) {
        this.deviceReolutionAggs = deviceReolutionAggs;
    }

    public List<ListDTO> getList() {
        return list;
    }

    public void setList(List<ListDTO> list) {
        this.list = list;
    }

    public List<Integer> getScriptNoAggs() {
        return scriptNoAggs;
    }

    public void setScriptNoAggs(List<Integer> scriptNoAggs) {
        this.scriptNoAggs = scriptNoAggs;
    }

    public List<String> getScriptDescrAggs() {
        return scriptDescrAggs;
    }

    public void setScriptDescrAggs(List<String> scriptDescrAggs) {
        this.scriptDescrAggs = scriptDescrAggs;
    }

    public List<Integer> getDeviceScreenSizeAggs() {
        return deviceScreenSizeAggs;
    }

    public void setDeviceScreenSizeAggs(List<Integer> deviceScreenSizeAggs) {
        this.deviceScreenSizeAggs = deviceScreenSizeAggs;
    }

    public List<String> getDeviceReleaseVerAggs() {
        return deviceReleaseVerAggs;
    }

    public void setDeviceReleaseVerAggs(List<String> deviceReleaseVerAggs) {
        this.deviceReleaseVerAggs = deviceReleaseVerAggs;
    }

    public List<DeviceListDTO> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceListDTO> deviceList) {
        this.deviceList = deviceList;
    }

    public List<?> getScriptTagsAggs() {
        return scriptTagsAggs;
    }

    public void setScriptTagsAggs(List<?> scriptTagsAggs) {
        this.scriptTagsAggs = scriptTagsAggs;
    }

    public List<?> getDeviceRamAggs() {
        return deviceRamAggs;
    }

    public void setDeviceRamAggs(List<?> deviceRamAggs) {
        this.deviceRamAggs = deviceRamAggs;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public static class ResultCategoryAggsDTO {
        @JsonProperty("1")
        private Integer $1;
        @JsonProperty("9")
        private Integer $9;

        public Integer get$1() {
            return $1;
        }

        public void set$1(Integer $1) {
            this.$1 = $1;
        }

        public Integer get$9() {
            return $9;
        }

        public void set$9(Integer $9) {
            this.$9 = $9;
        }
    }

    public static class ListDTO {
        @JsonProperty("logresUrl")
        private String logresUrl;
        @JsonProperty("timeConsuming")
        private Integer timeConsuming;
        @JsonProperty("reportDevice")
        private ReportDeviceDTO reportDevice;
        @JsonProperty("ignoreMark")
        private Integer ignoreMark;
        @JsonProperty("inputParams")
        private String inputParams;
        @JsonProperty("errorCode")
        private Integer errorCode;
        @JsonProperty("subtaskid")
        private String subtaskid;
        @JsonProperty("hasSupplementary")
        private Integer hasSupplementary;
        @JsonProperty("reportLogExceptions")
        private List<?> reportLogExceptions;
        @JsonProperty("reportRunInfo")
        private ReportRunInfoDTO reportRunInfo;
        @JsonProperty("pferrorCode")
        private Integer pferrorCode;
        @JsonProperty("retryNum")
        private Integer retryNum;
        @JsonProperty("matchtime")
        private Long matchtime;
        @JsonProperty("scriptMark")
        private String scriptMark;
        @JsonProperty("outputParams")
        private String outputParams;
        @JsonProperty("resultCategory")
        private Integer resultCategory;
        @JsonProperty("reportScript")
        private ReportScriptDTO reportScript;
        @JsonProperty("subsubtaskid")
        private String subsubtaskid;
        @JsonProperty("originLogUrl")
        private String originLogUrl;
        @JsonProperty("id")
        private String id;
        @JsonProperty("taskid")
        private String taskid;

        public String getLogresUrl() {
            return logresUrl;
        }

        public void setLogresUrl(String logresUrl) {
            this.logresUrl = logresUrl;
        }

        public Integer getTimeConsuming() {
            return timeConsuming;
        }

        public void setTimeConsuming(Integer timeConsuming) {
            this.timeConsuming = timeConsuming;
        }

        public ReportDeviceDTO getReportDevice() {
            return reportDevice;
        }

        public void setReportDevice(ReportDeviceDTO reportDevice) {
            this.reportDevice = reportDevice;
        }

        public Integer getIgnoreMark() {
            return ignoreMark;
        }

        public void setIgnoreMark(Integer ignoreMark) {
            this.ignoreMark = ignoreMark;
        }

        public String getInputParams() {
            return inputParams;
        }

        public void setInputParams(String inputParams) {
            this.inputParams = inputParams;
        }

        public Integer getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }

        public String getSubtaskid() {
            return subtaskid;
        }

        public void setSubtaskid(String subtaskid) {
            this.subtaskid = subtaskid;
        }

        public Integer getHasSupplementary() {
            return hasSupplementary;
        }

        public void setHasSupplementary(Integer hasSupplementary) {
            this.hasSupplementary = hasSupplementary;
        }

        public List<?> getReportLogExceptions() {
            return reportLogExceptions;
        }

        public void setReportLogExceptions(List<?> reportLogExceptions) {
            this.reportLogExceptions = reportLogExceptions;
        }

        public ReportRunInfoDTO getReportRunInfo() {
            return reportRunInfo;
        }

        public void setReportRunInfo(ReportRunInfoDTO reportRunInfo) {
            this.reportRunInfo = reportRunInfo;
        }

        public Integer getPferrorCode() {
            return pferrorCode;
        }

        public void setPferrorCode(Integer pferrorCode) {
            this.pferrorCode = pferrorCode;
        }

        public Integer getRetryNum() {
            return retryNum;
        }

        public void setRetryNum(Integer retryNum) {
            this.retryNum = retryNum;
        }

        public Long getMatchtime() {
            return matchtime;
        }

        public void setMatchtime(Long matchtime) {
            this.matchtime = matchtime;
        }

        public String getScriptMark() {
            return scriptMark;
        }

        public void setScriptMark(String scriptMark) {
            this.scriptMark = scriptMark;
        }

        public String getOutputParams() {
            return outputParams;
        }

        public void setOutputParams(String outputParams) {
            this.outputParams = outputParams;
        }

        public Integer getResultCategory() {
            return resultCategory;
        }

        public void setResultCategory(Integer resultCategory) {
            this.resultCategory = resultCategory;
        }

        public ReportScriptDTO getReportScript() {
            return reportScript;
        }

        public void setReportScript(ReportScriptDTO reportScript) {
            this.reportScript = reportScript;
        }

        public String getSubsubtaskid() {
            return subsubtaskid;
        }

        public void setSubsubtaskid(String subsubtaskid) {
            this.subsubtaskid = subsubtaskid;
        }

        public String getOriginLogUrl() {
            return originLogUrl;
        }

        public void setOriginLogUrl(String originLogUrl) {
            this.originLogUrl = originLogUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public static class ReportDeviceDTO {
            @JsonProperty("aliasName")
            private String aliasName;
            @JsonProperty("brandName")
            private String brandName;
            @JsonProperty("modelid")
            private Integer modelid;
            @JsonProperty("ucomid")
            private String ucomid;
            @JsonProperty("deviceid")
            private String deviceid;
            @JsonProperty("releaseVer")
            private String releaseVer;
            @JsonProperty("dpiHeight")
            private Integer dpiHeight;
            @JsonProperty("cloud")
            private String cloud;
            @JsonProperty("modelName")
            private String modelName;
            @JsonProperty("screenSize")
            private Double screenSize;
            @JsonProperty("cloudMark")
            private Integer cloudMark;
            @JsonProperty("brandid")
            private Integer brandid;
            @JsonProperty("dpiWidth")
            private Integer dpiWidth;

            public String getAliasName() {
                return aliasName;
            }

            public void setAliasName(String aliasName) {
                this.aliasName = aliasName;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public Integer getModelid() {
                return modelid;
            }

            public void setModelid(Integer modelid) {
                this.modelid = modelid;
            }

            public String getUcomid() {
                return ucomid;
            }

            public void setUcomid(String ucomid) {
                this.ucomid = ucomid;
            }

            public String getDeviceid() {
                return deviceid;
            }

            public void setDeviceid(String deviceid) {
                this.deviceid = deviceid;
            }

            public String getReleaseVer() {
                return releaseVer;
            }

            public void setReleaseVer(String releaseVer) {
                this.releaseVer = releaseVer;
            }

            public Integer getDpiHeight() {
                return dpiHeight;
            }

            public void setDpiHeight(Integer dpiHeight) {
                this.dpiHeight = dpiHeight;
            }

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getModelName() {
                return modelName;
            }

            public void setModelName(String modelName) {
                this.modelName = modelName;
            }

            public Double getScreenSize() {
                return screenSize;
            }

            public void setScreenSize(Double screenSize) {
                this.screenSize = screenSize;
            }

            public Integer getCloudMark() {
                return cloudMark;
            }

            public void setCloudMark(Integer cloudMark) {
                this.cloudMark = cloudMark;
            }

            public Integer getBrandid() {
                return brandid;
            }

            public void setBrandid(Integer brandid) {
                this.brandid = brandid;
            }

            public Integer getDpiWidth() {
                return dpiWidth;
            }

            public void setDpiWidth(Integer dpiWidth) {
                this.dpiWidth = dpiWidth;
            }
        }

        public static class ReportRunInfoDTO {
            @JsonProperty("testProcesses")
            private List<TestProcessesDTO> testProcesses;
            @JsonProperty("videoInfo")
            private VideoInfoDTO videoInfo;
            @JsonProperty("errorCode")
            private Integer errorCode;
            @JsonProperty("stepInfo")
            private StepInfoDTO stepInfo;
            @JsonProperty("pfCode")
            private Integer pfCode;

            public List<TestProcessesDTO> getTestProcesses() {
                return testProcesses;
            }

            public void setTestProcesses(List<TestProcessesDTO> testProcesses) {
                this.testProcesses = testProcesses;
            }

            public VideoInfoDTO getVideoInfo() {
                return videoInfo;
            }

            public void setVideoInfo(VideoInfoDTO videoInfo) {
                this.videoInfo = videoInfo;
            }

            public Integer getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(Integer errorCode) {
                this.errorCode = errorCode;
            }

            public StepInfoDTO getStepInfo() {
                return stepInfo;
            }

            public void setStepInfo(StepInfoDTO stepInfo) {
                this.stepInfo = stepInfo;
            }

            public Integer getPfCode() {
                return pfCode;
            }

            public void setPfCode(Integer pfCode) {
                this.pfCode = pfCode;
            }

            public static class VideoInfoDTO {
                @JsonProperty("errorCode")
                private Integer errorCode;
                @JsonProperty("url")
                private String url;

                public Integer getErrorCode() {
                    return errorCode;
                }

                public void setErrorCode(Integer errorCode) {
                    this.errorCode = errorCode;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class StepInfoDTO {
                @JsonProperty("extension")
                private String extension;
                @JsonProperty("stepId")
                private Integer stepId;
                @JsonProperty("errorCode")
                private Integer errorCode;
                @JsonProperty("skip")
                private Integer skip;
                @JsonProperty("errorMsg")
                private String errorMsg;
                @JsonProperty("callTag")
                private String callTag;
                @JsonProperty("network")
                private Boolean network;
                @JsonProperty("descr")
                private String descr;
                @JsonProperty("similarity")
                private Integer similarity;
                @JsonProperty("resultCategory")
                private Integer resultCategory;
                @JsonProperty("action")
                private String action;
                @JsonProperty("lineNum")
                private Integer lineNum;
                @JsonProperty("startTime")
                private Long startTime;
                @JsonProperty("endTime")
                private Long endTime;
                @JsonProperty("networkStrength")
                private Integer networkStrength;

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public Integer getStepId() {
                    return stepId;
                }

                public void setStepId(Integer stepId) {
                    this.stepId = stepId;
                }

                public Integer getErrorCode() {
                    return errorCode;
                }

                public void setErrorCode(Integer errorCode) {
                    this.errorCode = errorCode;
                }

                public Integer getSkip() {
                    return skip;
                }

                public void setSkip(Integer skip) {
                    this.skip = skip;
                }

                public String getErrorMsg() {
                    return errorMsg;
                }

                public void setErrorMsg(String errorMsg) {
                    this.errorMsg = errorMsg;
                }

                public String getCallTag() {
                    return callTag;
                }

                public void setCallTag(String callTag) {
                    this.callTag = callTag;
                }

                public Boolean getNetwork() {
                    return network;
                }

                public void setNetwork(Boolean network) {
                    this.network = network;
                }

                public String getDescr() {
                    return descr;
                }

                public void setDescr(String descr) {
                    this.descr = descr;
                }

                public Integer getSimilarity() {
                    return similarity;
                }

                public void setSimilarity(Integer similarity) {
                    this.similarity = similarity;
                }

                public Integer getResultCategory() {
                    return resultCategory;
                }

                public void setResultCategory(Integer resultCategory) {
                    this.resultCategory = resultCategory;
                }

                public String getAction() {
                    return action;
                }

                public void setAction(String action) {
                    this.action = action;
                }

                public Integer getLineNum() {
                    return lineNum;
                }

                public void setLineNum(Integer lineNum) {
                    this.lineNum = lineNum;
                }

                public Long getStartTime() {
                    return startTime;
                }

                public void setStartTime(Long startTime) {
                    this.startTime = startTime;
                }

                public Long getEndTime() {
                    return endTime;
                }

                public void setEndTime(Long endTime) {
                    this.endTime = endTime;
                }

                public Integer getNetworkStrength() {
                    return networkStrength;
                }

                public void setNetworkStrength(Integer networkStrength) {
                    this.networkStrength = networkStrength;
                }
            }

            public static class TestProcessesDTO {
                @JsonProperty("stage")
                private String stage;
                @JsonProperty("totalTime")
                private Integer totalTime;
                @JsonProperty("name")
                private String name;
                @JsonProperty("startTime")
                private Long startTime;
                @JsonProperty("endTime")
                private Long endTime;

                public String getStage() {
                    return stage;
                }

                public void setStage(String stage) {
                    this.stage = stage;
                }

                public Integer getTotalTime() {
                    return totalTime;
                }

                public void setTotalTime(Integer totalTime) {
                    this.totalTime = totalTime;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Long getStartTime() {
                    return startTime;
                }

                public void setStartTime(Long startTime) {
                    this.startTime = startTime;
                }

                public Long getEndTime() {
                    return endTime;
                }

                public void setEndTime(Long endTime) {
                    this.endTime = endTime;
                }
            }
        }

        public static class ReportScriptDTO {
            @JsonProperty("scriptUrl")
            private String scriptUrl;
            @JsonProperty("scriptid")
            private Integer scriptid;
            @JsonProperty("scriptTags")
            private List<String> scriptTags;
            @JsonProperty("scriptMd5")
            private String scriptMd5;
            @JsonProperty("scriptType")
            private Integer scriptType;
            @JsonProperty("scriptDescr")
            private String scriptDescr;
            @JsonProperty("osType")
            private Integer osType;
            @JsonProperty("scriptNo")
            private Integer scriptNo;
            @JsonProperty("orderNum")
            private Integer orderNum;
            @JsonProperty("scriptSign")
            private String scriptSign;
            @JsonProperty("scriptName")
            private String scriptName;
            @JsonProperty("scriptTag")
            private String scriptTag;

            public String getScriptUrl() {
                return scriptUrl;
            }

            public void setScriptUrl(String scriptUrl) {
                this.scriptUrl = scriptUrl;
            }

            public Integer getScriptid() {
                return scriptid;
            }

            public void setScriptid(Integer scriptid) {
                this.scriptid = scriptid;
            }

            public List<String> getScriptTags() {
                return scriptTags;
            }

            public void setScriptTags(List<String> scriptTags) {
                this.scriptTags = scriptTags;
            }

            public String getScriptMd5() {
                return scriptMd5;
            }

            public void setScriptMd5(String scriptMd5) {
                this.scriptMd5 = scriptMd5;
            }

            public Integer getScriptType() {
                return scriptType;
            }

            public void setScriptType(Integer scriptType) {
                this.scriptType = scriptType;
            }

            public String getScriptDescr() {
                return scriptDescr;
            }

            public void setScriptDescr(String scriptDescr) {
                this.scriptDescr = scriptDescr;
            }

            public Integer getOsType() {
                return osType;
            }

            public void setOsType(Integer osType) {
                this.osType = osType;
            }

            public Integer getScriptNo() {
                return scriptNo;
            }

            public void setScriptNo(Integer scriptNo) {
                this.scriptNo = scriptNo;
            }

            public Integer getOrderNum() {
                return orderNum;
            }

            public void setOrderNum(Integer orderNum) {
                this.orderNum = orderNum;
            }

            public String getScriptSign() {
                return scriptSign;
            }

            public void setScriptSign(String scriptSign) {
                this.scriptSign = scriptSign;
            }

            public String getScriptName() {
                return scriptName;
            }

            public void setScriptName(String scriptName) {
                this.scriptName = scriptName;
            }

            public String getScriptTag() {
                return scriptTag;
            }

            public void setScriptTag(String scriptTag) {
                this.scriptTag = scriptTag;
            }
        }
    }

    public static class DeviceListDTO {
        @JsonProperty("cpuModel")
        private String cpuModel;
        @JsonProperty("gpuRenderer")
        private String gpuRenderer;
        @JsonProperty("cpuProcessor")
        private String cpuProcessor;
        @JsonProperty("brandStatus")
        private Integer brandStatus;
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("resolution")
        private String resolution;
        @JsonProperty("brandSpelling")
        private String brandSpelling;
        @JsonProperty("mac")
        private String mac;
        @JsonProperty("releaseVer")
        private String releaseVer;
        @JsonProperty("brandLogoUrl")
        private String brandLogoUrl;
        @JsonProperty("picUrl")
        private String picUrl;
        @JsonProperty("rom")
        private Integer rom;
        @JsonProperty("brandAbbr")
        private String brandAbbr;
        @JsonProperty("screenSize")
        private Integer screenSize;
        @JsonProperty("syspfName")
        private String syspfName;
        @JsonProperty("gpuVersion")
        private String gpuVersion;
        @JsonProperty("gpuVendor")
        private String gpuVendor;
        @JsonProperty("picUrlB")
        private String picUrlB;
        @JsonProperty("ram")
        private Integer ram;
        @JsonProperty("brandName")
        private String brandName;
        @JsonProperty("createtime")
        private Long createtime;
        @JsonProperty("otg")
        private Integer otg;
        @JsonProperty("serialNumber")
        private String serialNumber;
        @JsonProperty("modelid")
        private Integer modelid;
        @JsonProperty("onShelveTime")
        private Integer onShelveTime;
        @JsonProperty("modelAlias")
        private String modelAlias;
        @JsonProperty("weight")
        private Integer weight;
        @JsonProperty("nfc")
        private Integer nfc;
        @JsonProperty("picUrlM")
        private String picUrlM;
        @JsonProperty("osName")
        private Integer osName;
        @JsonProperty("deviceid")
        private String deviceid;
        @JsonProperty("cpuNum")
        private Integer cpuNum;
        @JsonProperty("dpiHeight")
        private Integer dpiHeight;
        @JsonProperty("modelName")
        private String modelName;
        @JsonProperty("cpuBrand")
        private String cpuBrand;
        @JsonProperty("bluetooth")
        private Integer bluetooth;
        @JsonProperty("brandId")
        private Integer brandId;
        @JsonProperty("cpuFreq")
        private Integer cpuFreq;
        @JsonProperty("offShelveTime")
        private Integer offShelveTime;
        @JsonProperty("imei")
        private String imei;
        @JsonProperty("fingermark")
        private Integer fingermark;
        @JsonProperty("updatetime")
        private Long updatetime;
        @JsonProperty("dpiWidth")
        private Integer dpiWidth;
        @JsonProperty("status")
        private Integer status;

        public String getCpuModel() {
            return cpuModel;
        }

        public void setCpuModel(String cpuModel) {
            this.cpuModel = cpuModel;
        }

        public String getGpuRenderer() {
            return gpuRenderer;
        }

        public void setGpuRenderer(String gpuRenderer) {
            this.gpuRenderer = gpuRenderer;
        }

        public String getCpuProcessor() {
            return cpuProcessor;
        }

        public void setCpuProcessor(String cpuProcessor) {
            this.cpuProcessor = cpuProcessor;
        }

        public Integer getBrandStatus() {
            return brandStatus;
        }

        public void setBrandStatus(Integer brandStatus) {
            this.brandStatus = brandStatus;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getResolution() {
            return resolution;
        }

        public void setResolution(String resolution) {
            this.resolution = resolution;
        }

        public String getBrandSpelling() {
            return brandSpelling;
        }

        public void setBrandSpelling(String brandSpelling) {
            this.brandSpelling = brandSpelling;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getReleaseVer() {
            return releaseVer;
        }

        public void setReleaseVer(String releaseVer) {
            this.releaseVer = releaseVer;
        }

        public String getBrandLogoUrl() {
            return brandLogoUrl;
        }

        public void setBrandLogoUrl(String brandLogoUrl) {
            this.brandLogoUrl = brandLogoUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public Integer getRom() {
            return rom;
        }

        public void setRom(Integer rom) {
            this.rom = rom;
        }

        public String getBrandAbbr() {
            return brandAbbr;
        }

        public void setBrandAbbr(String brandAbbr) {
            this.brandAbbr = brandAbbr;
        }

        public Integer getScreenSize() {
            return screenSize;
        }

        public void setScreenSize(Integer screenSize) {
            this.screenSize = screenSize;
        }

        public String getSyspfName() {
            return syspfName;
        }

        public void setSyspfName(String syspfName) {
            this.syspfName = syspfName;
        }

        public String getGpuVersion() {
            return gpuVersion;
        }

        public void setGpuVersion(String gpuVersion) {
            this.gpuVersion = gpuVersion;
        }

        public String getGpuVendor() {
            return gpuVendor;
        }

        public void setGpuVendor(String gpuVendor) {
            this.gpuVendor = gpuVendor;
        }

        public String getPicUrlB() {
            return picUrlB;
        }

        public void setPicUrlB(String picUrlB) {
            this.picUrlB = picUrlB;
        }

        public Integer getRam() {
            return ram;
        }

        public void setRam(Integer ram) {
            this.ram = ram;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public Long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Long createtime) {
            this.createtime = createtime;
        }

        public Integer getOtg() {
            return otg;
        }

        public void setOtg(Integer otg) {
            this.otg = otg;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public Integer getModelid() {
            return modelid;
        }

        public void setModelid(Integer modelid) {
            this.modelid = modelid;
        }

        public Integer getOnShelveTime() {
            return onShelveTime;
        }

        public void setOnShelveTime(Integer onShelveTime) {
            this.onShelveTime = onShelveTime;
        }

        public String getModelAlias() {
            return modelAlias;
        }

        public void setModelAlias(String modelAlias) {
            this.modelAlias = modelAlias;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getNfc() {
            return nfc;
        }

        public void setNfc(Integer nfc) {
            this.nfc = nfc;
        }

        public String getPicUrlM() {
            return picUrlM;
        }

        public void setPicUrlM(String picUrlM) {
            this.picUrlM = picUrlM;
        }

        public Integer getOsName() {
            return osName;
        }

        public void setOsName(Integer osName) {
            this.osName = osName;
        }

        public String getDeviceid() {
            return deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.deviceid = deviceid;
        }

        public Integer getCpuNum() {
            return cpuNum;
        }

        public void setCpuNum(Integer cpuNum) {
            this.cpuNum = cpuNum;
        }

        public Integer getDpiHeight() {
            return dpiHeight;
        }

        public void setDpiHeight(Integer dpiHeight) {
            this.dpiHeight = dpiHeight;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public String getCpuBrand() {
            return cpuBrand;
        }

        public void setCpuBrand(String cpuBrand) {
            this.cpuBrand = cpuBrand;
        }

        public Integer getBluetooth() {
            return bluetooth;
        }

        public void setBluetooth(Integer bluetooth) {
            this.bluetooth = bluetooth;
        }

        public Integer getBrandId() {
            return brandId;
        }

        public void setBrandId(Integer brandId) {
            this.brandId = brandId;
        }

        public Integer getCpuFreq() {
            return cpuFreq;
        }

        public void setCpuFreq(Integer cpuFreq) {
            this.cpuFreq = cpuFreq;
        }

        public Integer getOffShelveTime() {
            return offShelveTime;
        }

        public void setOffShelveTime(Integer offShelveTime) {
            this.offShelveTime = offShelveTime;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public Integer getFingermark() {
            return fingermark;
        }

        public void setFingermark(Integer fingermark) {
            this.fingermark = fingermark;
        }

        public Long getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Long updatetime) {
            this.updatetime = updatetime;
        }

        public Integer getDpiWidth() {
            return dpiWidth;
        }

        public void setDpiWidth(Integer dpiWidth) {
            this.dpiWidth = dpiWidth;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "TaskReportData{" +
                "totalRow=" + totalRow +
                ", deviceAliasNameAggs=" + deviceAliasNameAggs +
                ", totalPage=" + totalPage +
                ", resultCategoryAggs=" + resultCategoryAggs +
                ", pageSize=" + pageSize +
                ", deviceReolutionAggs=" + deviceReolutionAggs +
                ", list=" + list +
                ", scriptNoAggs=" + scriptNoAggs +
                ", scriptDescrAggs=" + scriptDescrAggs +
                ", deviceScreenSizeAggs=" + deviceScreenSizeAggs +
                ", deviceReleaseVerAggs=" + deviceReleaseVerAggs +
                ", deviceList=" + deviceList +
                ", scriptTagsAggs=" + scriptTagsAggs +
                ", deviceRamAggs=" + deviceRamAggs +
                ", page=" + page +
                '}';
    }
}
