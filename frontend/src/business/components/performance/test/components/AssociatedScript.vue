<template>
  <el-dialog :close-on-click-modal="false"
             :destroy-on-close="true"
             @close = "close"
             title="关联TestIn脚本" width="900px"
             :visible.sync="loadFileVisible">
    <div style="line-height: 30px;">
      已关联TestIn脚本：{{ associatedScript.testInScriptName?associatedScript.testInScriptNo +' '+ associatedScript.testInScriptName:'无' }}
    </div>
    <div v-if="associatedScript.testInScriptName" style="margin-top:20px;margin-bottom:20px">
      <span>覆盖安装：<el-switch
                        :active-value = "1"
                        :inactive-value = "0"
                        v-model="associatedScript.coverInstall">
                      </el-switch></span>
      <span style="margin-left:30px">清理数据：<el-switch
        :active-value = "1"
        :inactive-value = "0"
        v-model="associatedScript.cleanData">
      </el-switch></span>
      <span style="margin-left:30px">保持应用：<el-switch
        :active-value = "1"
        :inactive-value = "0"
        v-model="associatedScript.keepApp">
      </el-switch></span>
    </div>
    <el-divider></el-divider>
    <div style="padding-top:10px;padding-bottom:10px">
      <el-input style="width:300px;margin-right: 20px;" v-model="inputDesc" placeholder="请输入脚本描述" clearable></el-input>
      <el-button type="primary" @click="scriptSearch">搜索</el-button>
    </div>
    <el-table v-loading="projectLoadingResult.loading"
              class="basic-config"
              row-key="scriptNo"
              :data="tableData"
              @row-click="tableRowClick">

        <el-table-column label="" width="50" align="center">
        <template slot-scope="scope">
          <!-- {{&nbsp;}} 或者 {{""}}-->
          <el-radio v-model="currentScript" :label="scope.row.scriptNo">{{""}}</el-radio>
        </template>
      </el-table-column>
      <el-table-column
        prop="scriptNo"
        label="脚本id">
      </el-table-column>
      <el-table-column
        prop="scriptCreateDesc"
        label="描述">
      </el-table-column>
      <el-table-column
        prop="suiteName"
        label="应用名称">
      </el-table-column>
      <el-table-column
        label="更新时间">
        <template v-slot:default="scope">
          <i class="el-icon-time"/>
          <span class="last-modified">{{ scope.row.scriptUpdateTime | timestampFormatDate }}</span>
        </template>
      </el-table-column>
    </el-table>
    <ms-table-pagination :change="getProjectFiles" :current-page.sync="currentPage" :page-size.sync="pageSize"
                         :total="total"/>
                         <span slot="footer" class="dialog-footer">
    <el-button @click="close">取 消</el-button>
    <el-button type="primary" @click="submit">确 定</el-button>
  </span>

  </el-dialog>
</template>

<script>
import MsTablePagination from "@/business/components/common/pagination/TablePagination";
export default {
  name: "AssociatedScript",
  components: {
    MsTablePagination
  },
  data() {
    return {
      loadFileVisible: false,
      inputDesc:'',
      projectLoadingResult: {},
      currentPage: 1,
      pageSize: 5,
      total: 0,
      tableData: [],
      condition: {},
      currentScript:null,
      associatedScript:{
        coverInstall:0,
        cleanData:0,
        keepApp:0
      }
    };
  },
  methods: {
    async open(project) {
      this.projectId = project.projectId;
      this.caseId = project.id
      const temp = await this.getProjectFiles()
        console.log('temp',temp);
      console.log('project',project);
      this.loadFileVisible = true;
      this.getAssociatedScript()
    },
    getAssociatedScript(){
      this.$get('/testIn/script/getBind?msCaseId=' + this.caseId, res => {
        let data = res.data;
        this.associatedScript = {...this.associatedScript,...data}
        if(data)this.currentScript = data.testInScriptNo
        // console.log('res',data);
      });
    },
    close() {
      this.loadFileVisible = false;
      this.currentScript = null
      this.associatedScript = {
        coverInstall:0,
        cleanData:0,
        keepApp:0
      }
    },
    tableRowClick(row, column, event){
      this.currentScript = row.scriptNo
      this.associatedScript = {
        testInScriptNo:row.scriptNo,
        testInScriptName:row.scriptCreateDesc,
        coverInstall:0,
        cleanData:0,
        keepApp:0
      }
    },
    scriptSearch(){
      this.currentPage = 1
      this.getProjectFiles()
    },
    getProjectFiles() {
      const that = this
      // this.projectLoadingResult = this.$post('/performance/project/all/' + this.projectId + "/" + this.currentPage + "/" + this.pageSize, this.condition, res => {
      //   let data = res.data;
      //   this.total = data.itemCount;
      //   this.tableData = data.listObject;
      // });
      return new Promise(function(resolve, reject){
        that.projectLoadingResult = that.$get('/testIn/script/list/'+ that.currentPage + "/" + that.pageSize+'?msProjectId='+ that.projectId+'&scriptDesc='+that.inputDesc, res => {
          let data = res.data;
          that.total = data.itemCount;
          that.tableData = data.listObject;
          console.log('res',data);
          resolve(res)
        });
      })
      
    },
    submit(){
      let param = {
        "msCaseId": this.caseId,
        "testInScriptNo": this.associatedScript.testInScriptNo,
        "testInScriptName": this.associatedScript.testInScriptName,
        "coverInstall": this.associatedScript.coverInstall,
        "cleanData": this.associatedScript.cleanData,
        "keepApp": this.associatedScript.keepApp
      }
      this.$post('/testIn/script/bind', param, res => {
        let data = res;
        if(data.success){
          this.$message.success('关联成功');
          this.close()
        }else{
          this.$message.success('关联失败，请重试');
        }
      });
    }
  }
};
</script>

<style scoped>

</style>
