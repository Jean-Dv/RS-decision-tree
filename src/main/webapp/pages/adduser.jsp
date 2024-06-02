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
        <jsp:param name="title" value="Agregar orden" />
        <jsp:param name="hrefTitle" value="addorder.jsp" />
      </jsp:include>
      <%@ include file="../components/sidemenu.jsp" %>

        <!--
  Heads up! 👋

  Plugins:
    - @tailwindcss/forms
-->


        <main class="ml-60 max-h-screen p-8 mt-20 sm:overflow-auto sm:ml-16">
          <div class="mx-auto max-w-screen-md px-4 py-16 sm:px-6 lg:px-8">
            <div class="grid grid-cols-1 gap-x-16 gap-y-8 lg:grid-cols-5">
              <div class="lg:col-span-2 lg:py-12 lg:text-center lg:pl-8">
                <h3 class="text-4xl text-black">Agregar Usuario</h3>
              </div>
              <c:if test="${not empty errorMessage}">
                <div style="color: red;">
                  ${errorMessage}
                </div>
              </c:if>

              <div class="rounded-lg bg-white p-8 lg:col-span-3 lg:p-12">
                <form action="/rs_decision_tree/user" method="post" href="<%= urlToRecommendation %>" class="space-y-4">
                  <div class="flex flex-row gap-x-4 justify-center">
                    <div class="w-1/4">
                      <label for="remitterName"
                        class="relative block rounded-md border border-gray-200 shadow-sm focus-within:border-blue-600 focus-within:ring-1 focus-within:ring-blue-600">
                        <input type="text" name="name"
                          class="peer border-none bg-transparent placeholder-transparent focus:border-transparent focus:outline-none focus:ring-0 p-2 w-full"
                          placeholder="Nombre remitente" />
                        <span
                          class="pointer-events-none absolute start-2.5 top-0 -translate-y-1/2 bg-white p-0.5 text-xs text-gray-700 transition-all peer-placeholder-shown:top-1/2 peer-placeholder-shown:text-sm peer-focus:top-0 peer-focus:text-xs">
                          Name
                        </span>
                      </label>
                    </div>
                    <div class="w-1/4">
                      <label for="descriptionAddress"
                        class="relative block rounded-md border border-gray-200 shadow-sm focus-within:border-blue-600 focus-within:ring-1 focus-within:ring-blue-600">
                        <input type="text" name="lastName"
                          class="peer border-none bg-transparent placeholder-transparent focus:border-transparent focus:outline-none focus:ring-0 p-2 w-full"
                          placeholder="Descripción de dirección" />
                        <span
                          class="pointer-events-none absolute start-2.5 top-0 -translate-y-1/2 bg-white p-0.5 text-xs text-gray-700 transition-all peer-placeholder-shown:top-1/2 peer-placeholder-shown:text-sm peer-focus:top-0 peer-focus:text-xs">
                          Last Name
                        </span>
                      </label>
                    </div>
                  </div>
                  <div class="flex flex-row gap-x-4 justify-center">
                    <div class="w-1/4">
                      <select name="gender"
                        class="block border border-gray-200 shadow-sm w-full focus-within:border-blue-600 focus-within:ring-1 rounded-md bg-transparent border-gray-300 text-gray-700 text-sm sm:text-sm p-2">
                        <option value="">Gender </option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>

                      </select>
                    </div>
                    <div class="w-1/4">
                      <select name="nationality"
                        class="block border border-gray-200 shadow-sm w-full focus-within:border-blue-600 focus-within:ring-1 rounded-md bg-transparent border-gray-300 text-gray-700 text-sm sm:text-sm p-2">
                        <option value="">Nationality </option>
                        <option value="Colombia">Colombia</option>
                        <option value="EEUU">EEUU</option>

                      </select>



                    </div>
                  </div>
                  <div class="mt-6 flex justify-center">
                    <button type="submit"
                      class="inline-block w-1/2 rounded-lg bg-black px-5 py-3 font-medium text-white">

                      Envíar
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </main>




    </body>