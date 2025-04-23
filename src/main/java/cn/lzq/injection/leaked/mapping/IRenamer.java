/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */
package cn.lzq.injection.leaked.mapping;

import cn.lzq.injection.leaked.mapping.IMappingFile.*;

public interface IRenamer {
    default String rename(IPackage value) {
        return value.getMapped();
    }

    default String rename(IClass value) {
        return value.getMapped();
    }

    default String rename(IField value) {
        return value.getMapped();
    }

    default String rename(IMethod value) {
        return value.getMapped();
    }

    default String rename(IParameter value) {
        return value.getMapped();
    }
}
