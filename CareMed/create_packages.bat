@echo off

REM 设置根目录（根据你的项目路径调整）
set BASE_DIR=src\main\java\com\peiz\caremed

REM 子包列表
set PACKAGES=config controller service repository entity dto exception utils schedule notification payment auth monitoring

REM 创建目录
for %%P in (%PACKAGES%) do (
    mkdir "%BASE_DIR%\%%P"
    echo Created package: %BASE_DIR%\%%P
)

echo All packages have been created.
pause
