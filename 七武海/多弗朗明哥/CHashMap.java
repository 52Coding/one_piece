// HashTable synchronized.
// ConcurrentHashMap -> Segment(LOCK) -> HashEntry
// 初始容量、加载因子、并行度（用于推断分片数）
// 16,0.75,16

ConcurrentHashMap
// 相对效率高

// * 0.HashMap是非线程安全的哈希表，常用于单线程程序中。
//  * 
//  * 1.HashTable容器在激烈的并发环境下面效率低的原因：强一致性
//  *     （1）HashTable通过synchronized来保证线程安全的，当一个线程进行put到HashTable添加元素时，线程2不但不能put方法添加元素，也不能通过get获取元素。
//  *      （2） 访问HashTable的线程都必须竞争同一把锁
//  * 2.ConcurrentHashMap效率高的原因：弱一致性
//  *     （1）容器中有多把锁，每一把锁锁住的是容器中的一部分数据，当多个线程访问容器中的不同的数据段的时候，由于获取的是不同的锁，
//  *             所以不存在竞争的问题，从而提高并发访问效率。
//  *  （2）采用锁分段技术：首先将数据分成一段一段的存储，然后给每一段数据配置一把锁，当一个线程占有锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问。
//  *  （3）多线程对于同一个段数据的访问，是互斥的；但是对于不同片段的访问，却是可以同步进行的。

// other：
// *1. add(e) throw exception,将元素e插入到队列的末尾，如果插入成功，则返回true，如果插入失败 (队列已经满) 抛出异常
//  *2. remove(e) throw exception，移除队首元素，若移除成功，则返回true；若移除失败（队列为空）则抛出异常
//  *3. element() throw exception 获取队列首元素，若获取成功，则返回首元素，否则抛出异常 java.util.NoSuchElementException
//  * 
//  *
//  * 1.offer(E e)，将元素e插入到队列末尾，如果插入成功，则返回true，如果插入失败（队列已满）,返回false
//  * 2.poll(E e)，移除并获取队首元素，若成功，则返回队首元素，否则返回null
//  * 3.peek(E e),获取队首元素，若成功，则返回队首元素，否则则返回null




