cmake_minimum_required(VERSION 3.21)
project(vcpkg_cmake_helper)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_EXE_LINKER_FLAGS "-static")
add_executable(vcpkg_cmake_helper main.cpp)
