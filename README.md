android_packages_apps_RomThemer
===============================

this is a basic themechooser for stock Roms By SpaceCaker


What is This ThemeChooser app ?

ThemeChooser allows you to theme your device Bit similar to how CM Theme Engine.
This app allows you to have up to 4 themes preinstalled on the rom u are using * offcourse if there are 4 themes made for the rom  * 

How to Add Themes ? 

This is a step you will need to do ALWAYS!
Extract the RomThemer.apk with 7-zip and find the Assets folder
inside the assets folder u need to add these
theme_stock.apk <- this is ur Stock SystemUI.apk rename it as described >
theme_stock_framework.apk <- this is ur Stock framework-res.apk rename it as described >
theme_stock_twframework.apk <- this is ur Stock twframework-res.apk rename it as described >
theme_1.apk <- this is ur themed/moddified SystemUI.apk rename it as described >
theme_1_framework.apk <- this is ur themed/moddified framework-res.apk rename it as described >
theme_1_twframework.apk <- this is ur themed/moddified twframework-res.apk rename it as described >
theme_2.apk <- this is ur themed/moddified SystemUI.apk rename it as described >
theme_2_framework.apk <- this is ur themed/moddified framework-res.apk rename it as described >
theme_2_twframework.apk <- this is ur themed/moddified twframework-res.apk rename it as described >
theme_3.apk <- this is ur themed/moddified SystemUI.apk rename it as described >
theme_3_framework.apk <- this is ur themed/moddified framework-res.apk rename it as described >
theme_3_twframework.apk <- this is ur themed/moddified twframework-res.apk rename it as described >
theme_4.apk <- this is ur themed/moddified SystemUI.apk rename it as described >
theme_4_framework.apk <- this is ur themed/moddified framework-res.apk rename it as described >
theme_4_twframework.apk <- this is ur themed/moddified twframework-res.apk rename it as described >
these control the 4 theme buttons available inside the app
*if u have mistyped the names then the app will FC when u press on the theme button that uses that name*
If u want to have a custom Theme Preview go to res/drawable-mdpi
and add custom pngs called
stock_theme.png
theme_1.png
theme_2.png
theme_3.png
these pngs must be in this size = 112X168

then select all folders except androidmanifest.xml and open the Romthemer.apk as archive and just drag and drop the files inside the apk 

now zip the zip again and u can flash the app  


Note: if u modify the source and release a version that is *yours* then upload your source code aswell 
=====================================================================================================
i contributed this app sources only because i wanted the app to be open source 
so all modifications in the java files are all open sourced aswell 
if u mod share the code changes on git or other git associated website
