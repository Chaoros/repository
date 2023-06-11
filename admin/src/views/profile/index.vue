<template>
  <div class="app-container">
    <el-form ref="form" :model="form">
      <el-form-item label="用户ID">
        <el-input v-model="form.id" placeholder="ID" :readonly="true" />
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.username" placeholder="用户名" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="密码" type="password" />
      </el-form-item>
      <el-form-item label="邮箱地址">
        <el-input v-model="form.email" placeholder="邮箱地址" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="updateUser">修改个人信息</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { getUser, saveUser } from '@/api/user'

export default {
  data() {
    return {
      form: {}
    }
  },
  created() {
    getUser(this.$route.query.id).then(res => {
      this.form = res.data
    })
  },
  methods: {
    updateUser() {
      saveUser(this.form).then(() => {
        this.$message.success('修改个人信息成功')
      })
    }
  }
}
</script>

<style>

</style>
