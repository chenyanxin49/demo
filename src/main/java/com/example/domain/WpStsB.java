package com.example.domain;

public class WpStsB {
    /**
     * 污水处理设施编号
     */
    private String id;

    /**
     * 污水处理设施名称
     */
    private String stsnm;

    /**
     * 所在村
     */
    private String loc;

    /**
     * 位置
     */
    private String address;

    /**
     * 纬度
     */
    private Double lgtd;

    /**
     * 经度
     */
    private Double lttd;

    /**
     * 设计标准(立方米/天)
     */
    private Double ddstc;

    /**
     * 年设计处理污水量(万立方米)
     */
    private Double ydstc;

    /**
     * 处理工艺
     */
    private String process;

    /**
     * 排放标准（ 1-Ⅰ类，2-Ⅱ类，3-Ⅲ类，4-Ⅳ类，5-Ⅴ类，6-劣Ⅴ类,一级A-7,一级B-8）
     */
    private Integer target;

    /**
     * 排入水体
     */
    private String rlnm;

    /**
     * 排放方式
     */
    private String emistp;

    /**
     * 污水分类
     */
    private String pdosour;

    /**
     * 入河方式
     */
    private String inrvtp;

    /**
     * 管道大小
     */
    private String pdosize;

    /**
     * 主要污染物
     */
    private String keypollu;

    /**
     * 建设年月
     */
    private String esstym;

    /**
     * 工程投资(万元)
     */
    private Double capex;

    /**
     * 占地面积(平方米)
     */
    private Double farea;

    /**
     * 服务面积(平方米)
     */
    private Double sarea;

    /**
     * 服务范围
     */
    private String sercov;

    /**
     * 服务人口
     */
    private Integer serpop;

    /**
     * 养护单位
     */
    private String curdep;

    /**
     * 建设单位
     */
    private String builddep;

    /**
     * 设施类型 (1 污水处理厂，2 污水处理站)
     */
    private String sttp;

    /**
     * 1为自动站，0为人工站
     */
    private String isauto;

    /**
     * 排污口编码
     */
    private String pdocd;

    /**
     * 污水处理设施编号
     * @return ID 污水处理设施编号
     */
    public String getId() {
        return id;
    }

    /**
     * 污水处理设施编号
     * @param id 污水处理设施编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 污水处理设施名称
     * @return STSNM 污水处理设施名称
     */
    public String getStsnm() {
        return stsnm;
    }

    /**
     * 污水处理设施名称
     * @param stsnm 污水处理设施名称
     */
    public void setStsnm(String stsnm) {
        this.stsnm = stsnm == null ? null : stsnm.trim();
    }

    /**
     * 所在村
     * @return LOC 所在村
     */
    public String getLoc() {
        return loc;
    }

    /**
     * 所在村
     * @param loc 所在村
     */
    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    /**
     * 位置
     * @return ADDRESS 位置
     */
    public String getAddress() {
        return address;
    }

    /**
     * 位置
     * @param address 位置
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 纬度
     * @return LGTD 纬度
     */
    public Double getLgtd() {
        return lgtd;
    }

    /**
     * 纬度
     * @param lgtd 纬度
     */
    public void setLgtd(Double lgtd) {
        this.lgtd = lgtd;
    }

    /**
     * 经度
     * @return LTTD 经度
     */
    public Double getLttd() {
        return lttd;
    }

    /**
     * 经度
     * @param lttd 经度
     */
    public void setLttd(Double lttd) {
        this.lttd = lttd;
    }

    /**
     * 设计标准(立方米/天)
     * @return DDSTC 设计标准(立方米/天)
     */
    public Double getDdstc() {
        return ddstc;
    }

    /**
     * 设计标准(立方米/天)
     * @param ddstc 设计标准(立方米/天)
     */
    public void setDdstc(Double ddstc) {
        this.ddstc = ddstc;
    }

    /**
     * 年设计处理污水量(万立方米)
     * @return YDSTC 年设计处理污水量(万立方米)
     */
    public Double getYdstc() {
        return ydstc;
    }

    /**
     * 年设计处理污水量(万立方米)
     * @param ydstc 年设计处理污水量(万立方米)
     */
    public void setYdstc(Double ydstc) {
        this.ydstc = ydstc;
    }

    /**
     * 处理工艺
     * @return PROCESS 处理工艺
     */
    public String getProcess() {
        return process;
    }

    /**
     * 处理工艺
     * @param process 处理工艺
     */
    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    /**
     * 排放标准（ 1-Ⅰ类，2-Ⅱ类，3-Ⅲ类，4-Ⅳ类，5-Ⅴ类，6-劣Ⅴ类,一级A-7,一级B-8）
     * @return TARGET 排放标准（ 1-Ⅰ类，2-Ⅱ类，3-Ⅲ类，4-Ⅳ类，5-Ⅴ类，6-劣Ⅴ类,一级A-7,一级B-8）
     */
    public Integer getTarget() {
        return target;
    }

    /**
     * 排放标准（ 1-Ⅰ类，2-Ⅱ类，3-Ⅲ类，4-Ⅳ类，5-Ⅴ类，6-劣Ⅴ类,一级A-7,一级B-8）
     * @param target 排放标准（ 1-Ⅰ类，2-Ⅱ类，3-Ⅲ类，4-Ⅳ类，5-Ⅴ类，6-劣Ⅴ类,一级A-7,一级B-8）
     */
    public void setTarget(Integer target) {
        this.target = target;
    }

    /**
     * 排入水体
     * @return RLNM 排入水体
     */
    public String getRlnm() {
        return rlnm;
    }

    /**
     * 排入水体
     * @param rlnm 排入水体
     */
    public void setRlnm(String rlnm) {
        this.rlnm = rlnm == null ? null : rlnm.trim();
    }

    /**
     * 排放方式
     * @return EMISTP 排放方式
     */
    public String getEmistp() {
        return emistp;
    }

    /**
     * 排放方式
     * @param emistp 排放方式
     */
    public void setEmistp(String emistp) {
        this.emistp = emistp == null ? null : emistp.trim();
    }

    /**
     * 污水分类
     * @return PDOSOUR 污水分类
     */
    public String getPdosour() {
        return pdosour;
    }

    /**
     * 污水分类
     * @param pdosour 污水分类
     */
    public void setPdosour(String pdosour) {
        this.pdosour = pdosour == null ? null : pdosour.trim();
    }

    /**
     * 入河方式
     * @return INRVTP 入河方式
     */
    public String getInrvtp() {
        return inrvtp;
    }

    /**
     * 入河方式
     * @param inrvtp 入河方式
     */
    public void setInrvtp(String inrvtp) {
        this.inrvtp = inrvtp == null ? null : inrvtp.trim();
    }

    /**
     * 管道大小
     * @return PDOSIZE 管道大小
     */
    public String getPdosize() {
        return pdosize;
    }

    /**
     * 管道大小
     * @param pdosize 管道大小
     */
    public void setPdosize(String pdosize) {
        this.pdosize = pdosize == null ? null : pdosize.trim();
    }

    /**
     * 主要污染物
     * @return KEYPOLLU 主要污染物
     */
    public String getKeypollu() {
        return keypollu;
    }

    /**
     * 主要污染物
     * @param keypollu 主要污染物
     */
    public void setKeypollu(String keypollu) {
        this.keypollu = keypollu == null ? null : keypollu.trim();
    }

    /**
     * 建设年月
     * @return ESSTYM 建设年月
     */
    public String getEsstym() {
        return esstym;
    }

    /**
     * 建设年月
     * @param esstym 建设年月
     */
    public void setEsstym(String esstym) {
        this.esstym = esstym == null ? null : esstym.trim();
    }

    /**
     * 工程投资(万元)
     * @return CAPEX 工程投资(万元)
     */
    public Double getCapex() {
        return capex;
    }

    /**
     * 工程投资(万元)
     * @param capex 工程投资(万元)
     */
    public void setCapex(Double capex) {
        this.capex = capex;
    }

    /**
     * 占地面积(平方米)
     * @return FAREA 占地面积(平方米)
     */
    public Double getFarea() {
        return farea;
    }

    /**
     * 占地面积(平方米)
     * @param farea 占地面积(平方米)
     */
    public void setFarea(Double farea) {
        this.farea = farea;
    }

    /**
     * 服务面积(平方米)
     * @return SAREA 服务面积(平方米)
     */
    public Double getSarea() {
        return sarea;
    }

    /**
     * 服务面积(平方米)
     * @param sarea 服务面积(平方米)
     */
    public void setSarea(Double sarea) {
        this.sarea = sarea;
    }

    /**
     * 服务范围
     * @return SERCOV 服务范围
     */
    public String getSercov() {
        return sercov;
    }

    /**
     * 服务范围
     * @param sercov 服务范围
     */
    public void setSercov(String sercov) {
        this.sercov = sercov == null ? null : sercov.trim();
    }

    /**
     * 服务人口
     * @return SERPOP 服务人口
     */
    public Integer getSerpop() {
        return serpop;
    }

    /**
     * 服务人口
     * @param serpop 服务人口
     */
    public void setSerpop(Integer serpop) {
        this.serpop = serpop;
    }

    /**
     * 养护单位
     * @return CURDEP 养护单位
     */
    public String getCurdep() {
        return curdep;
    }

    /**
     * 养护单位
     * @param curdep 养护单位
     */
    public void setCurdep(String curdep) {
        this.curdep = curdep == null ? null : curdep.trim();
    }

    /**
     * 建设单位
     * @return BUILDDEP 建设单位
     */
    public String getBuilddep() {
        return builddep;
    }

    /**
     * 建设单位
     * @param builddep 建设单位
     */
    public void setBuilddep(String builddep) {
        this.builddep = builddep == null ? null : builddep.trim();
    }

    /**
     * 设施类型 (1 污水处理厂，2 污水处理站)
     * @return STTP 设施类型 (1 污水处理厂，2 污水处理站)
     */
    public String getSttp() {
        return sttp;
    }

    /**
     * 设施类型 (1 污水处理厂，2 污水处理站)
     * @param sttp 设施类型 (1 污水处理厂，2 污水处理站)
     */
    public void setSttp(String sttp) {
        this.sttp = sttp == null ? null : sttp.trim();
    }

    /**
     * 1为自动站，0为人工站
     * @return ISAUTO 1为自动站，0为人工站
     */
    public String getIsauto() {
        return isauto;
    }

    /**
     * 1为自动站，0为人工站
     * @param isauto 1为自动站，0为人工站
     */
    public void setIsauto(String isauto) {
        this.isauto = isauto == null ? null : isauto.trim();
    }

    /**
     * 排污口编码
     * @return PDOCD 排污口编码
     */
    public String getPdocd() {
        return pdocd;
    }

    /**
     * 排污口编码
     * @param pdocd 排污口编码
     */
    public void setPdocd(String pdocd) {
        this.pdocd = pdocd == null ? null : pdocd.trim();
    }
}