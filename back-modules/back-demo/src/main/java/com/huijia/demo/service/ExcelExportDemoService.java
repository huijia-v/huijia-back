package com.huijia.demo.service;

import com.alibaba.excel.EasyExcel;
import com.huijia.demo.domain.vo.ExportDemoVo;
import jakarta.annotation.Resource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author huijia
 * @date 2024/12/3 17:46
 */
public class ExcelExportDemoService {
    @Resource
    ThreadPoolTaskExecutor executor;
    private static final String EXPORT_DIR = "path/to/export/directory"; // 临时文件存储目录

    //从数据库查询数据
    public List<ExportDemoVo> getDataByPlace(String place) {
        List<ExportDemoVo> dataList = new ArrayList<>();
        return dataList;
    }

    // 数据导出：根据地方分片生成不同的 Sheet
    public void exportDataForPlace(String place, String filePath) {
        List<ExportDemoVo> dataList = getDataByPlaceFromDB(place);

        // 使用 EasyExcel 写入数据到 Excel 文件的不同 Sheet
        EasyExcel.write(filePath, ExportDemoVo.class)
                .sheet(place) // 每个地方对应一个 Sheet
                .doWrite(dataList);
    }

    private List<ExportDemoVo> getDataByPlaceFromDB(String place) {
        return null;
    }

    // 执行导出任务，采用多线程并发
    public void export() throws InterruptedException, ExecutionException {
        // 1. 定义地方列表
        List<String> places = Arrays.asList("北京", "上海", "广州", "深圳", "杭州");

        // 2. 设置线程池来并发处理不同地方的导出任务，此为 demo，真实环境线程池需要提前定义，
        //  不可每次执行都创建
//        ExecutorService executorService = Executors.newFixedThreadPool(places.size());
        List<Future<?>> futures = new ArrayList<>();

        // 3. 创建 Excel 文件路径
        String filePath = EXPORT_DIR + "/places.xlsx";

        // 4. 执行每个地方的导出任务
        for (String place : places) {
            Future<?> future = executor.submit(() -> {
                try {
                    exportDataForPlace(place, filePath); // 导出数据到对应的 Sheet
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            futures.add(future);
        }

        // 5. 等待所有任务完成
        for (Future<?> future : futures) {
            future.get();
        }

        // 6. 关闭线程池
        executor.shutdown();
        System.out.println("mianshiya Excel export has been completed.");
    }
}
