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

#############################





