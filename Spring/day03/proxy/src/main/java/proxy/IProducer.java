package proxy;

/**
 * 对生产厂家要求的接口
 *
 * @Author hustffx
 * @Date 2020/6/17 11:30
 */
public interface IProducer {
    /**
     * 销售
     *
     * @param money
     */
    void saleProduct(float money);

    /**
     * 售后
     *
     * @param money
     */
    void afterService(float money);
}
