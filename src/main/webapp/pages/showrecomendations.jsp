<html lang="en">
<%@ page import="java.util.List" %>
    <%@ page import="co.edu.uptc.model.User" %>

        <head>
            <title>Home</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <%@ include file="../common/import-js.jsp" %>
        </head>

        <body>

            <%@ include file="../components/navbar.jsp" %>

                <div class="overflow-x-auto rounded-lg border border-gray-200 " style="width: 50%; margin: 0  auto;">
                    <table class="min-w-full divide-y-2 divide-gray-200 bg-white text-sm">
                        <thead class="ltr:text-left rtl:text-right">
                            <tr>
                                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Name</th>
                                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Date of Birth</th>
                                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Role</th>
                                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Salary</th>
                            </tr>
                        </thead>
                    </table>
                </div>

                <% List<User> listaUsers =(List<User>) request.getSession().getAttribute("users");

                        for (User user : listaUsers){


                        %>
                        <div class="overflow-x-auto  rounded-lg border border-gray-200"
                            style="width: 50%; margin: 0 auto;">
                            <table class="min-w-full divide-y-2 divide-gray-200 bg-white text-sm">
                                <tbody class="divide-y divide-gray-200">
                                    <tr>
                                        <td class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">
                                            <%=user.getName() %>
                                        </td>
                                        <td class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">
                                            <%=user.getLastName() %>
                                        </td>
                                        <td class="whitespace-nowrap px-1 py-2 font-medium text-gray-900">
                                            <%=user.getGender() %>
                                        </td>
                                        <td class="whitespace-nowrap px-1 py-2 font-medium text-gray-900">$120,000</td>
                                    </tr>



                                </tbody>
                            </table>
                        </div>
                        <% } %>

        </body>