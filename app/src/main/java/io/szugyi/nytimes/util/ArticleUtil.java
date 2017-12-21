package io.szugyi.nytimes.util;

import android.support.annotation.Nullable;

import io.szugyi.nytimes.data.model.Article;
import io.szugyi.nytimes.data.model.Media;
import io.szugyi.nytimes.data.model.MediaMetadata;

public final class ArticleUtil {
    private static final String TARGET_TYPE = "image";
    private static final String TARGET_FORMAT = "Large";

    private ArticleUtil() {
    }

    @Nullable
    public static String getImageUrl(Article article) {
        if (article.getMedia() == null || article.getMedia().isEmpty()) {
            return null;
        }

        for (Media medium : article.getMedia()) {
            if (TARGET_TYPE.equals(medium.getType())) {
                if (medium.getMediaMetadata() == null || article.getMedia().isEmpty()) {
                    return null;
                }

                for (MediaMetadata metadata : medium.getMediaMetadata()) {
                    if (TARGET_FORMAT.equals(metadata.getFormat())) {
                        return metadata.getUrl();
                    }
                }

                return medium.getMediaMetadata().get(0).getUrl();
            }
        }

        return null;
    }
}
