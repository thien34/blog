package com.blog.core.admin.permission.controller;

import com.blog.core.admin.permission.dto.request.PermissionRequest;
import com.blog.core.admin.permission.service.PermissionService;
import com.blog.core.common.PageResponse;
import com.blog.core.common.ResponseData;
import com.blog.core.common.ResponseError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/admin/permissions")
@RequiredArgsConstructor
@Slf4j
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping()
    public ResponseData<?> createPermission(@RequestBody PermissionRequest request) {
        try {
            permissionService.addPermission(request);
            return new ResponseData<>(HttpStatus.OK.value(), "Permission created successfully");
        } catch (Exception e) {
            log.error("Error creating permission", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @GetMapping()
    public ResponseData<?> getPermissions(@RequestParam(defaultValue = "") String name,
                                          @RequestParam(defaultValue = "0") int pageNo,
                                          @RequestParam(defaultValue = "6") int pageSize) {
        try {
            PageResponse<?> response = permissionService.getPermissions(name, pageNo, pageSize);
            return new ResponseData<>(HttpStatus.OK.value(), "Permissions retrieved successfully", response);
        } catch (Exception e) {
            log.error("Error getting permissions", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseData<?> deletePermissions(@RequestBody List<Long> ids) {
        try {
            permissionService.deletePermission(ids);
            return new ResponseData<>(HttpStatus.OK.value(), "Permissions deleted successfully");
        } catch (Exception e) {
            log.error("Error deleting permissions", e);
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

}
