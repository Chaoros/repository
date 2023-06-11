<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="仓库名称">
        <el-input v-model="form.name" placeholder="仓库名称" />
      </el-form-item>
      <el-form-item label="仓库详情">
        <el-input v-model="form.detail" placeholder="仓库详情" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { saveWarehouse } from '@/api/warehouse'

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
      saveWarehouse(this.form).then(() => {
        this.$message.success('添加仓库成功')
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

