<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
  
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
    rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-9 text-right">
            <div class="btn-group btn-group-lg">
              <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown"> 인성면접 <span class="fa fa-caret-down"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li>
                  <a href="#">Action</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="col-md-2">
            <form role="form">
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="검색어 입력">
                  <span class="input-group-btn">
                    <a class="btn btn-success" type="submit">검색</a>
                  </span>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-2">
            <div class="btn-group btn-group-lg">
              <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown"> 인성면접 <span class="fa fa-caret-down"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li>
                  <a href="#">Action</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="col-md-9">
            <form role="form">
              <div class="form-group">
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="내용을 입력해 주세요">
                  <span class="input-group-btn">
                    <a class="btn btn-success" type="submit">등록</a>
                  </span>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container text-center">
        <div class="row">
          <div class="col-md-12">
            <table class="table text-center">
              <thead>
                <tr>
                  <th>스크랩</th>
                  <th>No</th>
                  <th>카테고리</th>
                  <th>질문내용</th>
                  <th>작성자</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${list }" var="question" varStatus="sts">
	                <tr>
	                <c:choose>
	                	<c:when test="${loginUser.customerID eq question.customerID }">
	                		<td><a href="#"><i class="fa fa-2x -o fa-star"></i></a></td>	
	                	</c:when>
	                	<c:otherwise>
	                		<td><a href="#"><i class="fa fa-2x -o fa-star-o"></i></a></td>
	                	</c:otherwise>
	                </c:choose>
	                
	                    <td>${sts.count }</td>
	                    <td>${question.category }</td>
	                    <td>${question.question }</td>
	                    <td>${question.customerID }</td>
	                    
	                    <c:choose>
	                	<c:when test="${loginUser.customerID eq question.customerID }">
	                		<td>
			                	<button>삭제</button>
			                </td>	
	                	</c:when>
	                	<c:when test="${loginUser.customerID eq loginUser.adminID }">
	                		<td>
			                	<button>삭제</button>
			                </td>	
	                	</c:when>
	                	<c:otherwise>
	                	</c:otherwise>
	                </c:choose>
	                    
	                </tr>
                </c:forEach>
                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <div class="section text-center">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div>
            
              <!-- <button>&lt;</button> -->
              <a class="btn btn-xs btn-info btnPlay" href="${ctx }/question/list.do?pageNum=${curPageNum - 1 }">&lt;</a><!-- do로 넘겨줌 pageNum -->
              <a class="btn btn-xs btn-info btnPlay" href="${ctx }/question/list.do?pageNum=0">1</a><!-- do로 넘겨줌 pageNum --> <!-- 무조건 있는 1페이지 -->
              <c:forEach items="${sizeList }" var="element" varStatus="sts">
                <a class="btn btn-xs btn-info btnPlay" href="${ctx }/question/list.do?pageNum=${sts.count }">${sts.count + 1 }</a><!-- do로 넘겨줌 pageNum -->
              	<%-- <input type="button">${sts.count + 1 }</button> --%> 
              </c:forEach>
              <a class="btn btn-xs btn-info btnPlay" href="${ctx }/question/list.do?pageNum=${curPageNum + 1 }">&gt;</a><!-- do로 넘겨줌 pageNum -->
				<!-- <button>&gt;</button> -->
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>