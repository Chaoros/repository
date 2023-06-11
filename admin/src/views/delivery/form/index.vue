<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="货品">
        <el-select v-model="form.commodityId" placeholder="请选择货品">
          <el-option v-for="item in commodityList" :key="item.id" :value="item.id" :label="item.coding+item.name" />
        </el-select>
      </el-form-item>
      <el-form-item label="出库数量">
        <el-input v-model="form.number" placeholder="出库数量" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { commodityList } from '@/api/commodity'
import { insertRepository } from '@/api/repository'

export default {
  data() {
    return {
      form: {
        commodityId: '',
        type: 0
      },
      commodityList: [],
      allowEdit: this.$store.getters.role === 1
    }
  },
  created() {
    commodityList().then(res => {
      this.commodityList = res.data
    })
  },
  methods: {
    onSubmit() {
      insertRepository({
        ...this.form,
        userId: this.$store.getters.userId
      }).then(() => {
        this.$message.success('出库成功')
      })
    },
    onCancel() {
      this.$message({
        message: 'cancel!',
        type: 'warning'
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

