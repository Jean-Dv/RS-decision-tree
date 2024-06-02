<%@ page import="java.util.List"%>
<%@ page import="co.edu.uptc.model.Movie"%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
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
    <jsp:param name="title" value="Editar orden" />
    <jsp:param name="hrefTitle" value="editorder.jsp" />
  </jsp:include>
  <%@ include file="../components/sidemenu.jsp" %>
      <link href="https://cdn.jsdelivr.net/npm/keen-slider@6.8.6/keen-slider.min.css" rel="stylesheet" />
      <script type="module">
        import KeenSlider from 'https://cdn.jsdelivr.net/npm/keen-slider@6.8.6/+esm'

        // Initialization for the first slider
        const keenSlider1 = new KeenSlider(
          '#keen-slider-1',
          {
            loop: true,
            slides: {
              origin: 'center',
              perView: 1.25,
              spacing: 16,
            },
            breakpoints: {
              '(min-width: 1024px)': {
                slides: {
                  origin: 'auto',
                  perView: 1.5,
                  spacing: 32,
                },
              },
            },
          },
          []
        )

        document.getElementById('keen-slider-previous-1').addEventListener('click', () => keenSlider1.prev())
        document.getElementById('keen-slider-next-1').addEventListener('click', () => keenSlider1.next())

        // Initialization for the second slider
        const keenSlider2 = new KeenSlider(
          '#keen-slider-2',
          {
            loop: true,
            slides: {
              origin: 'center',
              perView: 1.25,
              spacing: 16,
            },
            breakpoints: {
              '(min-width: 1024px)': {
                slides: {
                  origin: 'auto',
                  perView: 1.5,
                  spacing: 32,
                },
              },
            },
          },
          []
        )

        document.getElementById('keen-slider-previous-2').addEventListener('click', () => keenSlider2.prev())
        document.getElementById('keen-slider-next-2').addEventListener('click', () => keenSlider2.next())
      </script>
      <section class="bg-gray-50">
        <div class="mx-auto max-w-[1340px] px-4 py-12 sm:px-6 lg:me-0 lg:py-16 lg:pe-0 lg:ps-8 xl:py-24">
          <div class="grid grid-cols-1 gap-8 lg:grid-cols-3 lg:items-center lg:gap-16">
            <div class="max-w-xl text-center ltr:sm:text-left rtl:sm:text-right">
              <h2 class="text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
                Recommendation by Nationality
              </h2>
            </div>
            <div class="-mx-6 lg:col-span-2 lg:mx-0">
              <div id="keen-slider-1" class="keen-slider">
                <!-- For-->
                <% 
                    List<Movie> movies = (List<Movie>) request.getSession().getAttribute("moviesNationality");
                    if (!movies.isEmpty()) {
                        for (Movie movie : movies) {
                %>
                

                <div class="keen-slider__slide">
                  <blockquote
                      class="flex ml-10 h-full flex-col justify-between bg-white p-6 shadow-sm sm:p-8 lg:p-12 w-auto mx-auto"
                    >
                      <div>
                        <div class="mt-4">
                          <p class="text-2xl font-bold text-rose-600 sm:text-3xl">Movie</p>
                          <p class="mt-4 leading-relaxed text-gray-700">
                            <%=movie.getTitle() %>
                          </p>
                          <p class="text-xl font-bold text-rose-500 sm:text-2xl mt-4">Genders</p>
                          <p class="mt-4 leading-relaxed text-gray-700">
                            <%=movie.getGenres() %>
                          </p>
                        </div>
                      </div>
                    </blockquote>
                </div>
                <%
                        }
                    } else {
                %>
                <div class="keen-slider__slide">
                    <blockquote
                        class="flex h-full flex-col justify-between bg-white p-6 shadow-sm sm:p-8 lg:p-12 w-full mx-auto"
                      >
                    <p class="text-xl">No movies found in the session.</p>
                    </blockquote>
                </div>
                <%
                    }
                %>
                <!--end for-->
              </div>
            </div>
          </div>
      
          <div class="mt-8 flex justify-center gap-4 lg:hidden">
            <button
              aria-label="Previous slide"
              id="keen-slider-previous-1"
              class="rounded-full border border-rose-600 p-4 text-rose-600 transition hover:bg-rose-600 hover:text-white"
            >
              <svg
                class="size-5 -rotate-180 transform"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9 5l7 7-7 7" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" />
              </svg>
            </button>
      
            <button
              aria-label="Next slide"
              id="keen-slider-next-1"
              class="rounded-full border border-rose-600 p-4 text-rose-600 transition hover:bg-rose-600 hover:text-white"
            >
              <svg
                class="h-5 w-5"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9 5l7 7-7 7" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" />
              </svg>
            </button>
          </div>
        </div>
      </section>

      <br>

      <section class="bg-gray-50">
        <div class="mx-auto max-w-[1340px] px-4 py-12 sm:px-6 lg:me-0 lg:py-16 lg:pe-0 lg:ps-8 xl:py-24">
          <div class="grid grid-cols-1 gap-8 lg:grid-cols-3 lg:items-center lg:gap-16">
            <div class="max-w-xl text-center ltr:sm:text-left rtl:sm:text-right">
              <h2 class="text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
               Recommendation by gender
              </h2>
            </div>  
            <div class="-mx-6 lg:col-span-2 lg:mx-0">
              <div id="keen-slider-2" class="keen-slider">
                <!-- For-->
                <% 
                    List<Movie> moviesGenres = (List<Movie>) request.getSession().getAttribute("moviesGenres");
                    if (!moviesGenres.isEmpty()) {
                        for (Movie movie : moviesGenres) {
                %>

                <div class="keen-slider__slide">
                  <blockquote
                      class="flex ml-10 h-full flex-col justify-between bg-white p-6 shadow-sm sm:p-8 lg:p-12 w-auto mx-auto"
                    >
                      <div>
                        <div class="mt-4">
                          <p class="text-2xl font-bold text-rose-600 sm:text-3xl">Movie</p>
                          <p class="mt-4 leading-relaxed text-gray-700">
                            <%=movie.getTitle() %>
                          </p>
                          <p class="text-xl font-bold text-rose-500 sm:text-2xl mt-4">Genders</p>
                          <p class="mt-4 leading-relaxed text-gray-700">
                            <%=movie.getGenres() %>
                          </p>
                        </div>
                      </div>
                    </blockquote>
                </div>
                <% 
                        }
                    } else {
                %>
                  <div class="keen-slider__slide">
                    <blockquote
                        class="flex h-full flex-col justify-between bg-white p-6 shadow-sm sm:p-8 lg:p-12 w-full mx-auto"
                      >
                    <p class="text-xl">No movies found in the session.</p>
                    </blockquote>
                  </div>
                <% 
                    }
                %>

                <!--end for-->
              </div>
              </div>
            </div>
          </div>
          <div class="mt-8 flex justify-center gap-4 lg:hidden">
            <button
              aria-label="Previous slide"
              id="keen-slider-previous-2"
              class="rounded-full border border-rose-600 p-4 text-rose-600 transition hover:bg-rose-600 hover:text-white"
            >
              <svg
                class="size-5 -rotate-180 transform"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9 5l7 7-7 7" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" />
              </svg>
            </button>

            <button
              aria-label="Next slide"
              id="keen-slider-next-2"
              class="rounded-full border border-rose-600 p-4 text-rose-600 transition hover:bg-rose-600 hover:text-white"
            >
              <svg
                class="h-5 w-5"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path d="M9 5l7 7-7 7" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" />
              </svg>
            </button>
          </div>
        </div>
      </section>

</body>