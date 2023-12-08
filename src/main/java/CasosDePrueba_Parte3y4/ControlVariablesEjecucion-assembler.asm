.386 
.model flat, stdcall 
option casemap :none  
include \masm32\include\windows.inc 
include \masm32\include\kernel32.inc 
include \masm32\include\masm32.inc  
includelib \masm32\lib\kernel32.lib 
includelib \masm32\lib\masm32.lib
include \masm32\include\user32.inc 
includelib \masm32\lib\user32.lib 

.data
AutoinvocacionFunciones db "Una funcion no puede llamarse a si misma.", 0 
OverflowSumaEnteros db "Se produjo un overflow en la suma de enteros.", 0 
OverflowProductoDouble db "Se produjo un un overflow en el producto de doubles.", 0 
error db "Error", 0 
printMensaje db "Print", 0 
_d2:main dd ?
_resDouble:main dd ?
_1.2d+10 dd 1.2d+10
_d1:main dd ?
_x1:main dd ?
_2.D+34 dd 2.D+34
_resEntero:main dd ?

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaEnteros, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowProductoDouble, addr error, MB_OK 
invoke ExitProcess, 0 
main:
MOV EAX, x1
ADD EAX, 999999
JO errorSumaEnteros
MOV @aux1, EAX
MOV EAX , @aux1
MOV resEntero, EAX
FLD 2.D+34
FST d1
FLD 1.2d+10
FST d2
FLD d1
FMUL d2
JO errorProductoDouble
FST @aux2
FLD @aux2
FST resDouble
invoke ExitProcess, 0 
end main