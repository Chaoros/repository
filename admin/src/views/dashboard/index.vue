<template>
    <div class="dashboard-container">
      欢迎来到仓库管理系统
    </div>
</template>

<script>
import { mapGetters } from 'vuex'
// import * as echarts from 'echarts'
export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
