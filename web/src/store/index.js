import { createStore } from 'vuex'

const MEMBER = "MEMBER";

export default createStore({
  state: { //声明初始化
    member: window.SessionStorage.get(MEMBER) || {}
  },
  getters: {
  },
  mutations: { //相当于set方法
    setMember (state, _member){
      state.member = _member;
      window.SessionStorage.set(MEMBER,_member);
    }
  },
  actions: { //异步

  },
  modules: {
  }
})
