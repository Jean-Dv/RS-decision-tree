<%@ page import="java.util.List" %>
  <%@ page import="co.edu.uptc.model.User" %>
    <%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
      <%String urlToRecommendation="/rs_decision_tree/recommendation" ; %>

        <html lang="en">

        <head>
          <title>Home</title>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <%@ include file="../common/import-js.jsp" %>
        </head>

        <body>
          <jsp:include page="../components/navbar.jsp">
            <jsp:param name="section" value="Ordenes" />
            <jsp:param name="hrefSection" value="orders.jsp" />
            <jsp:param name="title" value="Home" />
            <jsp:param name="hrefTitle" value="orders.jsp" />
          </jsp:include>
          <%@ include file="../components/sidemenu.jsp" %>

            <main class="ml-60 max-h-screen overflow-auto p-8 mt-20 sm:ml-16">
              
              <div class="overflow-x-auto">
                <table class="min-w-full divide-y-2 divide-gray-200 bg-white text-sm">
                  <thead class="ltr:text-left rtl:text-right">
                    <tr>
                      <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Name</th>
                      <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Last Name</th>
                      <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Gender</th>
                      <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Nationality</th>
                      <th class="px-4 py-2"></th>
                    </tr>
                  </thead>

                  <% List<User> listUsers = (List<User>) request.getSession().getAttribute("listUsers");



                      for (User user : listUsers){

                      urlToRecommendation = urlToRecommendation + "?gender=" + user.getGender() + "&nationality=" +
                      user.getNationality();


                      %>
                      <tbody class="divide-y divide-gray-200">

                        <tr>
                          <td class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">
                            <%=user.getName()%>
                          </td>
                          <td class="whitespace-nowrap px-4 py-2 text-gray-700">
                            <%=user.getLastName()%>
                          </td>
                          <td class="whitespace-nowrap px-4 py-2 text-gray-700">
                            <%=user.getGender()%>
                          </td>
                          <td class="whitespace-nowrap px-4 py-2 text-gray-700">
                            <%=user.getNationality()%>
                          </td>
                          <td class="whitespace-nowrap px-4 py-2">
                            <a href="<%= urlToRecommendation %>" class="inline-block rounded bg-indigo-600 px-4 py-2 text-xs font-medium text-white
                              hover:bg-indigo-700">
                              View
                            </a>
                          </td>
                        </tr>
                      </tbody>


                      <% urlToRecommendation="/rs_decision_tree/recommendation" ; } %>

                </table>
              </div>

            </main>
        </body>