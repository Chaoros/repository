<template>
  <div class="app-container">
    <el-form inline>
      <el-form-item label="搜索">
        <el-input v-model="searchInput" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchList">搜索</el-button>
      </el-form-item>
      <el-form-item v-if="allowEdit">
        <el-button type="success" @click="clickInsert">添加用户信息</el-button>
      </el-form-item>
    </el-form>
    <el-table
      v-loading="listLoading"
      :data="list2"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="用户名">
        <template slot-scope="scope">
          {{ scope.row.username }}
        </template>
      </el-table-column>
      <el-table-column label="邮箱号码">
        <template slot-scope="scope">
          {{ scope.row.email }}
        </template>
      </el-table-column>
      <el-table-column label="角色">
        <template slot-scope="scope">
          {{ scope.row.type==1?'管理员':'用户' }}
        </template>
      </el-table-column>
      <el-table-column v-if="allowEdit" label="操作" width="200">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="clickUpdate(scope.row)">修改</el-button>
          <el-button type="danger" size="mini" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      title="用户信息"
      :visible.sync="visible"
      width="30%"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="form.username" placeholder="用户名" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" placeholder="密码" type="password" />
        </el-form-item>
        <el-form-item label="邮箱地址">
          <el-input v-model="form.email" placeholder="邮箱地址" />
        </el-form-item>
        <el-form-item label="角色">
          <el-select v-model="form.type" placeholder="用户角色">
            <el-option label="用户" :value="0" />
            <el-option label="管理员" :value="1" />
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="visible = false">关闭</el-button>
        <el-button type="primary" @click="handleUpdate">提交</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { userList, delUser, saveUser } from '@/api/user'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: [],
      list2: [],
      listLoading: true,
      visible: false,
      form: {},
      searchInput: '',
      allowEdit: this.$store.getters.role === 1
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      userList().then(response => {
        this.list = response.data
        this.searchList()
        this.listLoading = false
      })
    },
    handleDelete(id) {
      delUser(id).then(() => {
        this.$message.success('删除成功')
        this.fetchData()
      })
    },
    clickUpdate(row) {
      this.form = { ...row }
      this.visible = true
    },
    clickInsert() {
      this.form = {}
      this.visible = true
    },
    handleUpdate() {
      saveUser(this.form).then(() => {
        this.$message.success('修改信息成功')
        this.visible = false
        this.fetchData()
      })
    },
    searchList() {
      this.list2 = this.list.filter(item => {
        return item.username.match(this.searchInput)
      })
    }
  }
}
</script>
