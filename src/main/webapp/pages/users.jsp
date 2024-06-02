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
              <div class="flex justify-end mb-2">
                <div class="inline-flex rounded-lg border border-gray-100 bg-gray-100 p-1 justify-between">
                  <button type="button"
                    class="inline-flex items-center gap-2 rounded-md px-4 py-2 text-sm text-gray-500 hover:text-gray-700 focus:relative">
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path
                        d="M6 8C6 7.44772 6.44772 7 7 7H17C17.5523 7 18 7.44772 18 8C18 8.55228 17.5523 9 17 9H7C6.44772 9 6 8.55228 6 8Z"
                        fill="currentColor" />
                      <path
                        d="M8 12C8 11.4477 8.44772 11 9 11H15C15.5523 11 16 11.4477 16 12C16 12.5523 15.5523 13 15 13H9C8.44772 13 8 12.5523 8 12Z"
                        fill="currentColor" />
                      <path
                        d="M11 15C10.4477 15 10 15.4477 10 16C10 16.5523 10.4477 17 11 17H13C13.5523 17 14 16.5523 14 16C14 15.4477 13.5523 15 13 15H11Z"
                        fill="currentColor" />
                    </svg>

                    Ordenar
                  </button>
                  <button type="button"
                    class="inline-flex items-center gap-2 rounded-md bg-white px-4 py-2 text-sm text-gray-500 hover:text-gray-700 focus:relative"
                    onclick="window.location.href='addorder.jsp'">
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path fill-rule="evenodd" clip-rule="evenodd"
                        d="M2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12ZM12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4Z"
                        fill="currentColor" />
                      <path fill-rule="evenodd" clip-rule="evenodd"
                        d="M13 7C13 6.44772 12.5523 6 12 6C11.4477 6 11 6.44772 11 7V11H7C6.44772 11 6 11.4477 6 12C6 12.5523 6.44772 13 7 13H11V17C11 17.5523 11.4477 18 12 18C12.5523 18 13 17.5523 13 17V13H17C17.5523 13 18 12.5523 18 12C18 11.4477 17.5523 11 17 11H13V7Z"
                        fill="currentColor" />
                    </svg>

                    Añadir
                  </button>

                </div>
              </div>


              <div class="overflow-x-auto">
                <table class="min-w-full divide-y-2 divide-gray-200 bg-white text-sm">
                  <thead class="ltr:text-left rtl:text-right">
                    <tr>
                      <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Name</th>
                      <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Date of Birth</th>
                      <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Role</th>
                      <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Salary</th>
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
                          <td class="whitespace-nowrap px-4 py-2 text-gray-700">$20,000</td>
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