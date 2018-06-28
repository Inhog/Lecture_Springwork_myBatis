<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">List</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Advanced Tables
                        </div>
                        <form role="form" method="POST" action="<c:url value='/member/delete'/>">
                        <button type ="submit">DELETE</button>
                        <!-- /.panel-heading -->
                        <input type="hidden" name ="MEMBER_SEQ" value ="dummy_id"/>
                        
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
											<th><input type="checkbox" id="selecctall" /></th>
                                            <th>MEMBER_ID</th>
                                            <th>NAME</th>
                                            <th>CELLPHONE</th>
                                            <th>EMAIL</th>
                                            <th>Update</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
										<c:forEach items="${resultMap.resultList}" var="resultData" varStatus="loop">
	                                        <tr class="${(loop.index+1)%2 == 2 ? 'odd gradeX' : 'even gradeC'}">
												<td><input type="checkbox" class="checkbox" name="MEMBER_SEQ" value="${resultData.MEMBER_SEQ}" /></td>
												<td>
													<a href="<c:url value="/member/read?MEMBER_SEQ=${resultData.MEMBER_SEQ}" />">
													${resultData.MEMBER_ID}</a>
												</td>
												<td>${resultData.NAME}</td>
												<td>${resultData.CELLPHONE}</td>
												<td>${resultData.EMAIL}</td>
												<td>
													<a href="<c:url value="/member/update?MEMBER_SEQ=${resultData.MEMBER_SEQ}&forwardView=/member/edit" />">
													Update</a>
												</td>
												<td>
													<a href="<c:url value="/member/delete?MEMBER_SEQ=${resultData.MEMBER_SEQ}&forwardView=/member/list" />">
													Delete</a>
												</td>
	                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                    <c:set var = "page" value ="${resultMap.pagination}"/>
                    <p>Showing ${page.pageBegin} to ${page.pageEnd} of ${page.totalCount} entries</p>
                     <a href="<c:url value="/member/list_pagination?curPage=${page.prevPage}" />">Previous</a>
									<c:forEach var="pageNum" begin="${page.blockStart}" end="${page.blockEnd}">
										<c:choose>
											<c:when test="${pageNum == page.curPage }">
												<a href="#">${pageNum}</a>
											</c:when>
											<c:otherwise>
												<a href="<c:url value="/member/list_pagination?curPage=${pageNum}" />">${pageNum}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
					<a href="<c:url value="/member/list_pagination?curPage=${page.nextPage}" />">Next</a>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </form>
					</div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

