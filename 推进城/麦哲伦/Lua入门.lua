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
键值对、普通值最好不要混用，要么{"red", "black"}，要么{first="red", second="black"}
追尾 s[#s+1] = something
table.getn(tblTest1)
table.concat (table [, sep [, i [, j ] ] ])     类似hive concat、concat_ws
table.insert (table, [pos ,] value)     pos默认追加
table.maxn (table) 返回最大索引编号
table.remove (table [, pos])
table.sort (table [, comp]) 默认小到大
table.new 和 table.clear 预分配和释放

-- ngx_lua 模块提供的带缓存的时间接口
如 ngx.today, ngx.time, ngx.utctime, ngx.localtime, ngx.now, ngx.http_time，以及 ngx.cookie_time 等。

############################################ 高阶 

元方法重载：操作符及取下标等默认行为可自定修改
面向对象 

############################################## Nginx 相关

# 直接匹配网站根，通过域名访问网站首页比较频繁，使用这个会加速处理，官网如是说。
# 这里是直接转发给后端应用服务器了，也可以是一个静态首页
# 第一个必选规则
location = / {
    proxy_pass http://tomcat:8080/index
}

# 第二个必选规则是处理静态文件请求，这是 nginx 作为 http 服务器的强项
# 有两种配置模式，目录匹配或后缀匹配，任选其一或搭配使用
location ^~ /static/ {
    root /webroot/static/;
}
location ~* \.(gif|jpg|jpeg|png|css|js|ico)$ {
    root /webroot/res/;
}

# 第三个规则就是通用规则，用来转发动态请求到后端应用服务器
# 非静态文件请求就默认是动态请求，自己根据实际把握
# 毕竟目前的一些框架的流行，带.php、.jsp后缀的情况很少了
location / {
    proxy_pass http://tomcat:8080/
}

redirect 语法
server {
    listen 80;
    server_name start.igrow.cn;
    index index.html index.php;
    root html;
    if ($http_host !~ "^star\.igrow\.cn$") {
        rewrite ^(.*) http://star.igrow.cn$1 redirect;
    }
}
防盗链
location ~* \.(gif|jpg|swf)$ {
    valid_referers none blocked start.igrow.cn sta.igrow.cn;
    if ($invalid_referer) {
       rewrite ^/ http://$host/logo.png;
    }
}
根据文件类型设置过期时间
location ~* \.(js|css|jpg|jpeg|gif|png|swf)$ {
    if (-f $request_filename) {
        expires 1h;
        break;
    }
}
禁止访问某个目录
location ~* \.(txt|doc)${
    root /data/www/wwwroot/linuxtone/test;
    deny all;
}

-- 为引用静态资源的url添加版本号，解决版本发布后的浏览器缓存问题
-- 浏览器缓存
-- Nginx缓存静态资源
-- nginx cache origin server static resource
-- load page then js/css/png
-- one then another.


正向代理就像一个跳板机

ip_hash：每个请求按访问 IP 的 hash 结果分配，这样来自同一个 IP 的访客固定访问一个后端服务器，有效解决了动态网页存在的 session 共享问题。

-- 利用Lua进行前置处理，不过后端（高并发）






