<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="客户名称">
        <el-input v-model="form.name" placeholder="姓名" />
      </el-form-item>
      <el-form-item label="客户地址">
        <el-input v-model="form.address" placeholder="省市" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">添加</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { saveCustomer } from '@/api/customer'

export default {
  data() {
    return {
      form: {

      }
    }
  },
  created() {
  },
  methods: {
    onSubmit() {
      saveCustomer(this.form).then(() => {
        this.$message.success('添加客户成功')
      })
    }
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
</style>

