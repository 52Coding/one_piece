######################## 安装
# wget http://luajit.org/download/LuaJIT-2.1.0-beta1.tar.gz
# tar -xvf LuaJIT-2.1.0-beta1.tar.gz
# cd LuaJIT-2.1.0-beta1
# make
# sudo make install

# luajit -v

# cat hello.lua
print("hello world")
# luajit hello.lua
hello world

-- 2907023106144108TGpL7V3fYMTmGN
ls -lh
ll -h 
ln -sf luajit-2.1.0-beta1 /usr/local/bin/luajit (b-->a)
luajit -v 
yum install -y vim 
[root@secure-spin-3 lua_tutourial]# luajit hello.lua
hello, Lua's world.
############################# data type
print("try data type:")

local a = "aaa"
print(type(a))
local b = 123.132
print(type(b))
print(math.floor(b))

print(c)

local d = {
    key = "value",
    123,
    [5] = 456,
    arr = {132, 444, 55}
}
print("lua table:")
print(type(d))
print(d.key)
print(d[1])
print(d.arr[2])

function ff()
    return 10 + 20
end
print(type(ff))
local e = ff
print(e())

############################# luajit base 
local 局部变量
~=
and or not 
"Hello".." World"

if xxx then
elseif xxx then 
else 
end

while xxx_condition do 
    -- sth
end 

没有分号，全靠换行结束

repeat 
    -- sth
until xxx_condition


for i=1, 10, 2 do

-- 迭代器，包括用于迭代文件中每行的（io.lines）、 迭代 table 元素的（pairs）、迭代数组元素的（ipairs）、迭代字符串中单词的（string.gmatch）
for i,v in ipairs(arr) do


goto failed
xxxxxxx
::failed::
    print("handle error with input", input)

-- 关于函数
-- 由于全局变量一般会污染全局名字空间，同时也有性能损耗（即查询全局环境表的开销），因此我们应当尽量使用“局部函数”
-- 可无return，亦可多
-- table按引用传递，其余按值传递
-- 入参和返回shape均不严格控制，遵从顺序匹配

print("hello", "world")

xxx.lua
require("xxx")

string 库(小写)
string.byte(s [, i [, j ]]) 返回asc码
string.char (...)   asc码转为字串
string.upper(s)
string.lower(s)
string.len(s) #？
string.find(s, p [, init [, plain]])    起止下标
string.format(formatstring, ...)
string.match(s, p [, init])     返回匹配字串，类似java regex match。优先使用ngx_lua 模块提供的 ngx.re.match
string.gmatch(s, p)     返回模式串P迭代器，可用于for循环。优先使用 ngx_lua 模块提供的 ngx.re.gmatch
string.rep(s, n)    复制n次
string.sub(s, i [, j])  返回字串
string.gsub(s, p, r [, n])  全局替换。优先使用 ngx_lua 模块提供的 ngx.re.gsub
string.reverse (s)


table，可理解为一种特殊的索引数组，索引可为字串or数字
table库


############################################ 高阶 




