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
_qq:main:a:f dd ?
_4 dd 4
_g:main:a dd ?
_h:main:a dd ?
_r:main:b dd ?
_m:main:a dd ?

.code
invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowSumaEnteros, addr error, MB_OK 
invoke ExitProcess, 0 
invoke MessageBox, NULL, addr OverflowProductoDouble, addr error, MB_OK 
invoke ExitProcess, 0 
f:
MOV EAX , 4
MOV qq, EAX
ret
main:
MOV EAX , 4
MOV h, EAX
gcall f
invoke ExitProcess, 0 
end main