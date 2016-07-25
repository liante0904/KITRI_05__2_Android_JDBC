<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="MemberDTO.MemberDTO" %>
<%@ page import="java.util.ArrayList" %>

<%
   ArrayList<MemberDTO> l = (ArrayList)request.getAttribute("dtoL");
%>
   <members>
      <% for(MemberDTO dtoL:l){%>
         <member>
            <vName><%=dtoL.getMem_name() %></vName>
            <vId><%=dtoL.getMem_id() %></vId>
            <vPwd><%=dtoL.getMem_pwd() %></vPwd>
            <vEmail><%=dtoL.getMem_email() %></vEmail>
            <vPhone><%=dtoL.getMem_phone() %></vPhone>
            <vAddr><%=dtoL.getMem_addr() %></vAddr>
         </member>
      <%} %>
   </members>

