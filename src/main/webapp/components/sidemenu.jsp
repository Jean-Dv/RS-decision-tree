<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<aside class="fixed inset-y-0 left-0 bg-white shadow-md max-h-screen  sm:w-auto">
    <div class="flex h-screen w-16 flex-col justify-between border-e bg-white">
  <div>
  <div class="inline-flex size-16 items-center justify-center">
      <span class="grid size-10 place-content-center rounded-lg bg-gray-100 text-xs text-gray-600">
        RDT
      </span>
    </div>

    <div class="border-t border-gray-100">
      <div class="px-2">
        <div class="py-4">
          <a
            href="#"
            class="t group relative flex justify-center rounded bg-blue-50 px-2 py-1.5 text-blue-700"
          >
            <svg
              width="24"
          height="24"
          viewBox="0 0 24 24"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
            >
              <path
               fill-rule="evenodd"
              clip-rule="evenodd"
              d="M2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12ZM12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4Z"
              fill="currentColor"
              />
              <path
                 fill-rule="evenodd"
                clip-rule="evenodd"
                d="M13 7C13 6.44772 12.5523 6 12 6C11.4477 6 11 6.44772 11 7V11H7C6.44772 11 6 11.4477 6 12C6 12.5523 6.44772 13 7 13H11V17C11 17.5523 11.4477 18 12 18C12.5523 18 13 17.5523 13 17V13H17C17.5523 13 18 12.5523 18 12C18 11.4477 17.5523 11 17 11H13V7Z"
                fill="currentColor"
              />
            </svg>

            <span
              class="invisible absolute start-full top-1/2 ms-4 -translate-y-1/2 rounded bg-gray-900 px-2 py-1.5 text-xs font-medium text-white group-hover:visible"
            >
              Añadir
            </span>
          </a>
        </div>

        <ul class="space-y-1 border-t border-gray-100 pt-4">
          <li>
            <a
              href="#"
              class="group relative flex justify-center rounded px-2 py-1.5 text-gray-500 hover:bg-gray-50 hover:text-gray-700"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="size-5 opacity-75"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                stroke-width="2"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z"
                />
              </svg>

              <span
                class="invisible absolute start-full top-1/2 ms-4 -translate-y-1/2 rounded bg-gray-900 px-2 py-1.5 text-xs font-medium text-white group-hover:visible"
              >
                Usuarios
              </span>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </div>

  <div class="sticky inset-x-0 bottom-0 border-t border-gray-100 bg-white p-2">
    <form action="#">
      <button
        type="submit"
        class="group relative flex w-full justify-center rounded-lg px-2 py-1.5 text-sm text-gray-500 hover:bg-gray-50 hover:text-gray-700"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="size-5 opacity-75"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          stroke-width="2"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1"
          />
        </svg>

        <span
          class="invisible absolute start-full top-1/2 ms-4 -translate-y-1/2 rounded bg-gray-900 px-2 py-1.5 text-xs font-medium text-white group-hover:visible"
        >
          Logout
        </span>
      </button>
    </form>
  </div>
</div>
  </aside>