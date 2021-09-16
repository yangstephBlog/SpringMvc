```
创建拦截器并说明源码道理
通过在xml配置拦截器，执行顺序与你配置的拦截器顺序相关，
根据debug得知
DispatchServlet的doDispatch()会调用
HandlerExecutionChain中的三个方法
boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response)
void applyPostHandle(HttpServletRequest request, HttpServletResponse response, @Nullable ModelAndView mv)
void triggerAfterCompletion(HttpServletRequest request, HttpServletResponse response, @Nullable Exception ex)
除了applyPreHandle是按照正序遍历数组，其余两个都是按照倒序遍历数组


```